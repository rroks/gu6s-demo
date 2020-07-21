package fen.fen.controller;

import cn.hutool.crypto.digest.Digester;
import fen.fen.model.RestResponse;
import fen.fen.model.query.LoginQuery;
import fen.fen.model.vo.LoginFailedVo;
import fen.fen.util.ResponseGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("Login")
@Slf4j
@RequestMapping
public class LoginController {

    @PostMapping("/login")
    @ApiOperation(value = "Login api", notes = "login")
    public RestResponse<LoginFailedVo> login(@RequestBody LoginQuery query, HttpServletRequest request) {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Subject subject = SecurityUtils.getSubject();
        String msg = "";
        try {
            Digester sha = new Digester(Sha256Hash.ALGORITHM_NAME);
            sha.setDigestCount(6);
            String key = query.getPassword();
            key = sha.digestHex(key);
            log.info(key);
            subject.login(new UsernamePasswordToken(query.getUsername(), query.getPassword()));
            msg = "Login Successful!";
            return ResponseGenerator.generateSuccess(null, msg);
        } catch (UnknownAccountException e) {
            msg = "UnknownAccountException -- > invalid username";
        } catch (AuthenticationException e) {
            msg = "IncorrectCredentialsException -- > invalid password";
        }
        return ResponseGenerator.generateFailure(null, msg);
    }

    @GetMapping("/test")
    @ApiOperation(value = "test api", notes = "test")
    public RestResponse<Object> test() {
        return ResponseGenerator.generateSuccess();
    }
}
