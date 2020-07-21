package fen.fen.aspect;

import cn.hutool.json.JSONUtil;
import fen.fen.constant.HttpCodeConstant;
import fen.fen.model.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenyufeng
 */
@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.info("GENERAL EXCEPTION HAPPENED! " + e.getMessage());
        RestResponse<Object> response = new RestResponse<>();
        response.setCode(HttpCodeConstant.FAIL.getCode());
        response.setMessage(e.getMessage());
        response.setData(req.getQueryString());
        return JSONUtil.toJsonStr(response);
    }
}
