package com.example.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "test1", catalog = "")
public class TaskEntity {
    private int taskId;
    private String taskInfo;
    private Double taskBonus;
    private Timestamp taskBeginTime;
    private Timestamp taskEndTime;
    private Date taskPublishTime;

    @Id
    @Column(name = "task_id")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "task_info")
    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    @Basic
    @Column(name = "task_bonus")
    public Double getTaskBonus() {
        return taskBonus;
    }

    public void setTaskBonus(Double taskBonus) {
        this.taskBonus = taskBonus;
    }

    @Basic
    @Column(name = "task_begin_time")
    public Timestamp getTaskBeginTime() {
        return taskBeginTime;
    }

    public void setTaskBeginTime(Timestamp taskBeginTime) {
        this.taskBeginTime = taskBeginTime;
    }

    @Basic
    @Column(name = "task_end_time")
    public Timestamp getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Timestamp taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    @Basic
    @Column(name = "task_publish_time")
    public Date getTaskPublishTime() {
        return taskPublishTime;
    }

    public void setTaskPublishTime(Date taskPublishTime) {
        this.taskPublishTime = taskPublishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return taskId == that.taskId &&
                Objects.equals(taskInfo, that.taskInfo) &&
                Objects.equals(taskBonus, that.taskBonus) &&
                Objects.equals(taskBeginTime, that.taskBeginTime) &&
                Objects.equals(taskEndTime, that.taskEndTime) &&
                Objects.equals(taskPublishTime, that.taskPublishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskInfo, taskBonus, taskBeginTime, taskEndTime, taskPublishTime);
    }
}
