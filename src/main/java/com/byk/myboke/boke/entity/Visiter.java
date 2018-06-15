package com.byk.myboke.boke.entity;

import java.util.Date;

public class Visiter {
    private String id;

    private String visiterIp;

    private Date time;

    private Integer delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVisiterIp() {
        return visiterIp;
    }

    public void setVisiterIp(String visiterIp) {
        this.visiterIp = visiterIp == null ? null : visiterIp.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}