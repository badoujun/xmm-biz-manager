package com.xmm.biz.vo.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "用户信息返回")
public class AdminUserResult implements Serializable {

    private static final long serialVersionUID = -300862847307544339L;

    @ApiModelProperty(value="ID",position=1)
    private long id;

    @ApiModelProperty(value="组织ID",position=2)
    private long groupid;

    @ApiModelProperty(value="用户名",position=3)
    private String username;

    @ApiModelProperty(value="密码",position=4)
    private String pwd;

    @ApiModelProperty(value="真实姓名",position=5)
    private String realname;

    @ApiModelProperty(value="状态,1-正常,2-禁用",position=6)
    private int state;

    @ApiModelProperty(value="创建时间",position=7)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;

    @ApiModelProperty(value="更新时间",position=8)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updatetime;

    @ApiModelProperty(value="更新人",position=9)
    private String updator;

    @ApiModelProperty(value="角色ID",position=10)
    private long roleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGroupid() {
        return groupid;
    }

    public void setGroupid(long groupid) {
        this.groupid = groupid;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
