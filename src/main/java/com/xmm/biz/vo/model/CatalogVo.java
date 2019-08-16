package com.xmm.biz.vo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "目录对象")
public class CatalogVo implements Serializable {

    private static final long serialVersionUID = 5670625692565251100L;

    @ApiModelProperty(value="目录名",position=1)
    private String catalogName;

    @ApiModelProperty(value="图标",position=2)
    private String icon;

    @ApiModelProperty(value="菜单集合",position=3)
    private List<MenuVo> menus;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuVo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVo> menus) {
        this.menus = menus;
    }
}
