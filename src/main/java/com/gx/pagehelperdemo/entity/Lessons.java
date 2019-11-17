package com.gx.pagehelperdemo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Lessons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lessonid;

    /**
     * 课程名称
     */
    @Column(name = "lesson_name")
    private String lessonName;

    /**
     * 课程内容
     */
    @Column(name = "lesson_content")
    private String lessonContent;

    /**
     * 备注
     */
    private String remark;

    /**
     * 全部分数
     */
    private Long allmarks;

    /**
     * 启用否(1：是；0：否)
     */
    private Boolean isused;

    private Date updatetime;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return lessonid
     */
    public Integer getLessonid() {
        return lessonid;
    }

    /**
     * @param lessonid
     */
    public void setLessonid(Integer lessonid) {
        this.lessonid = lessonid;
    }

    /**
     * 获取课程名称
     *
     * @return lesson_name - 课程名称
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * 设置课程名称
     *
     * @param lessonName 课程名称
     */
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
    }

    /**
     * 获取课程内容
     *
     * @return lesson_content - 课程内容
     */
    public String getLessonContent() {
        return lessonContent;
    }

    /**
     * 设置课程内容
     *
     * @param lessonContent 课程内容
     */
    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent == null ? null : lessonContent.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取全部分数
     *
     * @return allmarks - 全部分数
     */
    public Long getAllmarks() {
        return allmarks;
    }

    /**
     * 设置全部分数
     *
     * @param allmarks 全部分数
     */
    public void setAllmarks(Long allmarks) {
        this.allmarks = allmarks;
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
        sb.append(", lessonid=").append(lessonid);
        sb.append(", lessonName=").append(lessonName);
        sb.append(", lessonContent=").append(lessonContent);
        sb.append(", remark=").append(remark);
        sb.append(", allmarks=").append(allmarks);
        sb.append(", isused=").append(isused);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}