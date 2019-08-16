package com.xmm.biz.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * admin_group
 * @author 
 */
public class AdminGroup implements Serializable {
    private Long id;

    /**
     * 组织名
     */
    private String groupname;

    /**
     * 父级组织ID
     */
    private Long parentid;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 状态,1-正常,2-禁用
     */
    private Byte state;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 更新人
     */
    private String updator;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminGroup other = (AdminGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroupname() == null ? other.getGroupname() == null : this.getGroupname().equals(other.getGroupname()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getUpdator() == null ? other.getUpdator() == null : this.getUpdator().equals(other.getUpdator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupname() == null) ? 0 : getGroupname().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getUpdator() == null) ? 0 : getUpdator().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupname=").append(groupname);
        sb.append(", parentid=").append(parentid);
        sb.append(", sort=").append(sort);
        sb.append(", state=").append(state);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", updator=").append(updator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}