package com.gx.pagehelperdemo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeid;

    private Integer userid;

    private Integer lessonid;

    /**
     * 分数
     */
    private Long marks;

    /**
     * 最后分数
     */
    private Long endmarks;

    /**
     * 是否必修(1：是；0：否)
     */
    private Boolean isneed;

    /**
     * 启用否(1：是；0：否)
     */
    private Boolean isused;

    private Date updatetime;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return gradeid
     */
    public Integer getGradeid() {
        return gradeid;
    }

    /**
     * @param gradeid
     */
    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
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
     * 获取分数
     *
     * @return marks - 分数
     */
    public Long getMarks() {
        return marks;
    }

    /**
     * 设置分数
     *
     * @param marks 分数
     */
    public void setMarks(Long marks) {
        this.marks = marks;
    }

    /**
     * 获取最后分数
     *
     * @return endmarks - 最后分数
     */
    public Long getEndmarks() {
        return endmarks;
    }

    /**
     * 设置最后分数
     *
     * @param endmarks 最后分数
     */
    public void setEndmarks(Long endmarks) {
        this.endmarks = endmarks;
    }

    /**
     * 获取是否必修(1：是；0：否)
     *
     * @return isneed - 是否必修(1：是；0：否)
     */
    public Boolean getIsneed() {
        return isneed;
    }

    /**
     * 设置是否必修(1：是；0：否)
     *
     * @param isneed 是否必修(1：是；0：否)
     */
    public void setIsneed(Boolean isneed) {
        this.isneed = isneed;
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
        sb.append(", gradeid=").append(gradeid);
        sb.append(", userid=").append(userid);
        sb.append(", lessonid=").append(lessonid);
        sb.append(", marks=").append(marks);
        sb.append(", endmarks=").append(endmarks);
        sb.append(", isneed=").append(isneed);
        sb.append(", isused=").append(isused);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}