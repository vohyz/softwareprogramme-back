package com.example.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "taskdrafts", schema = "test1", catalog = "")
public class TaskdraftsEntity {
    private int id;
    private String taskInfo;
    private Double taskBonus;
    private Timestamp taskBeginTime;
    private Timestamp taskEndTime;
    private Date taskAddtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "task_addtime")
    public Date getTaskAddtime() {
        return taskAddtime;
    }

    public void setTaskAddtime(Date taskAddtime) {
        this.taskAddtime = taskAddtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskdraftsEntity that = (TaskdraftsEntity) o;
        return id == that.id &&
                Objects.equals(taskInfo, that.taskInfo) &&
                Objects.equals(taskBonus, that.taskBonus) &&
                Objects.equals(taskBeginTime, that.taskBeginTime) &&
                Objects.equals(taskEndTime, that.taskEndTime) &&
                Objects.equals(taskAddtime, that.taskAddtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskInfo, taskBonus, taskBeginTime, taskEndTime, taskAddtime);
    }
}
