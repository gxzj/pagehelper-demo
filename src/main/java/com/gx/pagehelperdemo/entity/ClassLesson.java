package com.gx.pagehelperdemo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "class_lesson")
public class ClassLesson implements Serializable {
    @Id
    @Column(name = "class_lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classLessonId;

    private Integer classesid;

    private Integer lessonid;

    /**
     * 启用否(1：是；0：否)
     */
    private Boolean isused;

    private Date updatetime;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return class_lesson_id
     */
    public Integer getClassLessonId() {
        return classLessonId;
    }

    /**
     * @param classLessonId
     */
    public void setClassLessonId(Integer classLessonId) {
        this.classLessonId = classLessonId;
    }

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
        sb.append(", classLessonId=").append(classLessonId);
        sb.append(", classesid=").append(classesid);
        sb.append(", lessonid=").append(lessonid);
        sb.append(", isused=").append(isused);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}