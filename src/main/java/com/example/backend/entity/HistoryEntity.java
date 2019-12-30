package com.example.backend.entity;

import org.joda.time.DateTime;

import javax.persistence.*;


@Entity
@Table(name = "History", schema = "SE-Platform", catalog = "")
@IdClass(HistoryEntityPK.class)
public class HistoryEntity {
    private int taskId;
    private int userId;
    private DateTime time;

    @Id
    @Column(name = "task_id")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time")
    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryEntity that = (HistoryEntity) o;

        if (taskId != that.taskId) return false;
        if (userId != that.userId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + userId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
