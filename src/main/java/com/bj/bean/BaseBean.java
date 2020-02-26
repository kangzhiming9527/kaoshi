package com.bj.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseBean implements Serializable {
    public BaseBean() {
        super();
        this.creationTime = new Date();
        this.updateTime = this.creationTime;
    }


    /**
     * 创建时间
     */
    @Column(name = "CREATION_TIME", nullable = false, updatable = false)
    private Date creationTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME", nullable = false, updatable = true)
    private Date updateTime;

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
