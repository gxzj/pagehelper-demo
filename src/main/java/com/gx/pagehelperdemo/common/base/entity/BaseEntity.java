package com.gx.pagehelperdemo.common.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BaseEntity {

    /**
     * 删除否(1：是；0：否)
     */
    private Boolean isused;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

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

}
