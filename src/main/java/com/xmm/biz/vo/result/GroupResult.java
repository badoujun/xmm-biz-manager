package com.xmm.biz.vo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "组织信息返回")
public class GroupResult implements Serializable {

    private static final long serialVersionUID = -341762064096820453L;

    @ApiModelProperty(value="组织编号",position=1)
    private long id;

    @ApiModelProperty(value="组织名",position=2)
    private String groupname;

    @ApiModelProperty(value="父级组织编号",position=3)
    private long parentid;

    @ApiModelProperty(value="排序",position=4)
    private byte sort;

    @ApiModelProperty(value="状态,1-正常,2-禁用",position=5)
    private byte state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public long getParentid() {
        return parentid;
    }

    public void setParentid(long parentid) {
        this.parentid = parentid;
    }

    public byte getSort() {
        return sort;
    }

    public void setSort(byte sort) {
        this.sort = sort;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
}
