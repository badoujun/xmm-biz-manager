package com.xmm.biz.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "请求基类")
public class BaseRequest implements Serializable
{
    private static final long serialVersionUID = -4153439395377945111L;

    @ApiModelProperty(value = "访问密匙", required = true)
    private String token;

    @ApiModelProperty(hidden = true)
    private long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
