package org.wang.goal.domain;

import java.sql.Timestamp;

public class Record {
    private Integer id;
    private String userId;
    private String status;
    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Recode{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
