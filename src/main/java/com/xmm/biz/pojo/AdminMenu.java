package com.xmm.biz.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * admin_menu
 * @author 
 */
public class AdminMenu implements Serializable {
    private Long id;

    /**
     * 目录ID
     */
    private Long catalogid;

    /**
     * 菜单名
     */
    private String menuname;

    /**
     * 地址
     */
    private String url;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 状态,1-正常,2-禁用
     */
    private Boolean state;

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

    public Long getCatalogid() {
        return catalogid;
    }

    public void setCatalogid(Long catalogid) {
        this.catalogid = catalogid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
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
        AdminMenu other = (AdminMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCatalogid() == null ? other.getCatalogid() == null : this.getCatalogid().equals(other.getCatalogid()))
            && (this.getMenuname() == null ? other.getMenuname() == null : this.getMenuname().equals(other.getMenuname()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
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
        result = prime * result + ((getCatalogid() == null) ? 0 : getCatalogid().hashCode());
        result = prime * result + ((getMenuname() == null) ? 0 : getMenuname().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
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
        sb.append(", catalogid=").append(catalogid);
        sb.append(", menuname=").append(menuname);
        sb.append(", url=").append(url);
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