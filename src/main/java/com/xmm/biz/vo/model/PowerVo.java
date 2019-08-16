package com.xmm.biz.vo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "权限对象")
public class PowerVo implements Serializable {

    private static final long serialVersionUID = 5930712854501603021L;

    @ApiModelProperty(value="权限名",position=1)
    private String powerName;

    @ApiModelProperty(value="权限枚举",position=2)
    private String powerEnum;

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerEnum() {
        return powerEnum;
    }

    public void setPowerEnum(String powerEnum) {
        this.powerEnum = powerEnum;
    }
}
