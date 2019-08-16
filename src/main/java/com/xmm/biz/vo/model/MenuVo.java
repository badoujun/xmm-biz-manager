package com.xmm.biz.vo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "菜单对象")
public class MenuVo implements Serializable {

    private static final long serialVersionUID = 701727533252779991L;

    @ApiModelProperty(value="菜单名",position=1)
    private String menuName;

    @ApiModelProperty(value="菜单地址",position=2)
    private String url;

    @ApiModelProperty(value="权限集合",position=3)
    private List<PowerVo> powers;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PowerVo> getPowers() {
        return powers;
    }

    public void setPowers(List<PowerVo> powers) {
        this.powers = powers;
    }
}
