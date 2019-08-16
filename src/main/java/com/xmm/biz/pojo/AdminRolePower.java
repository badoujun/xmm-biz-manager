package com.xmm.biz.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * admin_role_power
 * @author 
 */
public class AdminRolePower implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Long roleid;

    /**
     * 权限ID
     */
    private Long powerid;

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

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getPowerid() {
        return powerid;
    }

    public void setPowerid(Long powerid) {
        this.powerid = powerid;
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
        AdminRolePower other = (AdminRolePower) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
            && (this.getPowerid() == null ? other.getPowerid() == null : this.getPowerid().equals(other.getPowerid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getUpdator() == null ? other.getUpdator() == null : this.getUpdator().equals(other.getUpdator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        result = prime * result + ((getPowerid() == null) ? 0 : getPowerid().hashCode());
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
        sb.append(", roleid=").append(roleid);
        sb.append(", powerid=").append(powerid);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", updator=").append(updator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}