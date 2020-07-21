package fen.fen.model.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginQuery {
    @ApiModelProperty(value = "shiro", required = true, name = "用户名")
    private String username;
    @ApiModelProperty(value = "shiro", required = true, name = "密码")
    private String password;
}
