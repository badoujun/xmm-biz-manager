package com.xmm.biz.vo.result;

import com.xmm.biz.vo.model.CatalogVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "管理员信息返回")
public class AdminDataResult extends TokenResult{

    private static final long serialVersionUID = -7359291291321323382L;

    @ApiModelProperty(value="用户名",position=1)
    private String username;

    @ApiModelProperty(value="菜单集合",position=2)
    private List<CatalogVo> catalogList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CatalogVo> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<CatalogVo> catalogList) {
        this.catalogList = catalogList;
    }
}
