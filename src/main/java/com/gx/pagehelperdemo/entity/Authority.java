package com.gx.pagehelperdemo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorityid;

    /**
     * 角色ID
     */
    private Integer roleid;

    /**
     * 模块ID
     */
    private Integer moduleid;

    /**
     * 描述
     */
    @Column(name = "authority_describe")
    private String authorityDescribe;

    /**
     * URL地址
     */
    @Column(name = "url_address")
    private String urlAddress;

    /**
     * 启用否(1：是；0：否)
     */
    private Boolean isused;

    private Date updatetime;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return authorityid
     */
    public Integer getAuthorityid() {
        return authorityid;
    }

    /**
     * @param authorityid
     */
    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    /**
     * 获取角色ID
     *
     * @return roleid - 角色ID
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 设置角色ID
     *
     * @param roleid 角色ID
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取模块ID
     *
     * @return moduleid - 模块ID
     */
    public Integer getModuleid() {
        return moduleid;
    }

    /**
     * 设置模块ID
     *
     * @param moduleid 模块ID
     */
    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    /**
     * 获取描述
     *
     * @return authority_describe - 描述
     */
    public String getAuthorityDescribe() {
        return authorityDescribe;
    }

    /**
     * 设置描述
     *
     * @param authorityDescribe 描述
     */
    public void setAuthorityDescribe(String authorityDescribe) {
        this.authorityDescribe = authorityDescribe == null ? null : authorityDescribe.trim();
    }

    /**
     * 获取URL地址
     *
     * @return url_address - URL地址
     */
    public String getUrlAddress() {
        return urlAddress;
    }

    /**
     * 设置URL地址
     *
     * @param urlAddress URL地址
     */
    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress == null ? null : urlAddress.trim();
    }

    /**
     * 获取启用否(1：是；0：否)
     *
     * @return isused - 启用否(1：是；0：否)
     */
    public Boolean getIsused() {
        return isused;
    }

    /**
     * 设置启用否(1：是；0：否)
     *
     * @param isused 启用否(1：是；0：否)
     */
    public void setIsused(Boolean isused) {
        this.isused = isused;
    }

    /**
     * @return updatetime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authorityid=").append(authorityid);
        sb.append(", roleid=").append(roleid);
        sb.append(", moduleid=").append(moduleid);
        sb.append(", authorityDescribe=").append(authorityDescribe);
        sb.append(", urlAddress=").append(urlAddress);
        sb.append(", isused=").append(isused);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}