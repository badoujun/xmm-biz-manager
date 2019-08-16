package com.xmm.biz.vo.request;

import com.xmm.biz.constant.BaseException;
import com.xmm.biz.constant.ResultValueEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "登录请求对象")
public class AdminLoginRequest implements RequestCheck{

    @ApiModelProperty(value = "管理员账号,4-15位", required = true)
    private String username;

    @ApiModelProperty(value = "密码,6-15位", required = true)
    private String pwd;

    @Override
    public void toRequestCheck() {
        if(pwd == null || pwd.length() < 6 || pwd.length() > 15){
            throw new BaseException(ResultValueEnum.INPUT_PASSWORD_ERROR);
        }
        if(username == null || username.length() < 4 || username.length() > 15){
            throw new BaseException(ResultValueEnum.INPUT_USERNAME_ERROR);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
