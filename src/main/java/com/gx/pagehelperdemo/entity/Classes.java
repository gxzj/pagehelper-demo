package com.gx.pagehelperdemo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Classes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classesid;

    /**
     * 父级IDs
     */
    @Column(name = "far_classesid")
    private Integer farClassesid;

    /**
     * 班级名称
     */
    @Column(name = "classes_name")
    private String classesName;

    /**
     * 启用否(1：是；0：否)
     */
    private Boolean isused;

    private Date updatetime;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return classesid
     */
    public Integer getClassesid() {
        return classesid;
    }

    /**
     * @param classesid
     */
    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    /**
     * 获取父级IDs
     *
     * @return far_classesid - 父级IDs
     */
    public Integer getFarClassesid() {
        return farClassesid;
    }

    /**
     * 设置父级IDs
     *
     * @param farClassesid 父级IDs
     */
    public void setFarClassesid(Integer farClassesid) {
        this.farClassesid = farClassesid;
    }

    /**
     * 获取班级名称
     *
     * @return classes_name - 班级名称
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * 设置班级名称
     *
     * @param classesName 班级名称
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
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
        sb.append(", classesid=").append(classesid);
        sb.append(", farClassesid=").append(farClassesid);
        sb.append(", classesName=").append(classesName);
        sb.append(", isused=").append(isused);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}