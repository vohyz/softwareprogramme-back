package com.example.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Task", schema = "SE-Platform", catalog = "")
public class TaskEntity {
    private int taskId;
    private String taskTitle;
    private String taskInfo;
    private Integer taskType;
    private Double taskBonus;
    private Timestamp taskBeginTime;
    private Timestamp taskEndTime;
    private Date taskPublishTime;
    private int taskPublisherId;
    private Integer taskExecutorId;
    private String taskStatus;

    @Id
    @Column(name = "task_id")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "task_title")
    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
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
    @Column(name = "task_type")
    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
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

    @Basic
    @Column(name = "task_publisher_id")
    public int getTaskPublisherId() {
        return taskPublisherId;
    }

    public void setTaskPublisherId(int taskPublisherId) {
        this.taskPublisherId = taskPublisherId;
    }

    @Basic
    @Column(name = "task_executor_id")
    public Integer getTaskExecutorId() {
        return taskExecutorId;
    }

    public void setTaskExecutorId(Integer taskExecutorId) {
        this.taskExecutorId = taskExecutorId;
    }

    @Basic
    @Column(name = "task_status")
    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return taskId == that.taskId &&
                taskPublisherId == that.taskPublisherId &&
                Objects.equals(taskTitle, that.taskTitle) &&
                Objects.equals(taskInfo, that.taskInfo) &&
                Objects.equals(taskType, that.taskType) &&
                Objects.equals(taskBonus, that.taskBonus) &&
                Objects.equals(taskBeginTime, that.taskBeginTime) &&
                Objects.equals(taskEndTime, that.taskEndTime) &&
                Objects.equals(taskPublishTime, that.taskPublishTime) &&
                Objects.equals(taskExecutorId, that.taskExecutorId) &&
                Objects.equals(taskStatus, that.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskTitle, taskInfo, taskType, taskBonus, taskBeginTime, taskEndTime, taskPublishTime, taskPublisherId, taskExecutorId, taskStatus);
    }
}