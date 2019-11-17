package com.gx.pagehelperdemo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Module implements Serializable {
    /**
     * 模块ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleid;

    /**
     * 父模块ID
     */
    @Column(name = "far_moduleid")
    private Integer farModuleid;

    /**
     * 模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 资源路径
     */
    @Column(name = "source_url")
    private String sourceUrl;

    /**
     * 模块描述
     */
    @Column(name = "module_describe")
    private String moduleDescribe;

    /**
     * 启用否(1：是；0：否)
     */
    private Boolean isused;

    private Date updatetime;

    private Date createtime;

    private static final long serialVersionUID = 1L;

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
     * 获取父模块ID
     *
     * @return far_moduleid - 父模块ID
     */
    public Integer getFarModuleid() {
        return farModuleid;
    }

    /**
     * 设置父模块ID
     *
     * @param farModuleid 父模块ID
     */
    public void setFarModuleid(Integer farModuleid) {
        this.farModuleid = farModuleid;
    }

    /**
     * 获取模块名称
     *
     * @return module_name - 模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置模块名称
     *
     * @param moduleName 模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取资源路径
     *
     * @return source_url - 资源路径
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * 设置资源路径
     *
     * @param sourceUrl 资源路径
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    /**
     * 获取模块描述
     *
     * @return module_describe - 模块描述
     */
    public String getModuleDescribe() {
        return moduleDescribe;
    }

    /**
     * 设置模块描述
     *
     * @param moduleDescribe 模块描述
     */
    public void setModuleDescribe(String moduleDescribe) {
        this.moduleDescribe = moduleDescribe == null ? null : moduleDescribe.trim();
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
        sb.append(", moduleid=").append(moduleid);
        sb.append(", farModuleid=").append(farModuleid);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", sourceUrl=").append(sourceUrl);
        sb.append(", moduleDescribe=").append(moduleDescribe);
        sb.append(", isused=").append(isused);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}