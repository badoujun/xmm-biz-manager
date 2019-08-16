package com.xmm.biz.vo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "token返回")
public class TokenResult implements Serializable {

    private static final long serialVersionUID = -6891801659916699619L;

    @ApiModelProperty("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
