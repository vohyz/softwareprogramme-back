package com.example.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Task", schema = "SE-Platform")
public class TaskEntity {
    private int taskId;
    private String taskTitle;
    private String taskInfo;
    private String taskType;
    private Double taskBonus;
    private String taskBeginTime;
    private String taskEndTime;
    private String taskPublishTime;
    private String taskPublisherName;
    private String taskExecutorName;
    private String taskStatus;

    public TaskEntity(){}
    public TaskEntity(String userName,String taskTitle,String taskInfo,double taskBonus,String taskType,String publishTime,String endTime){
        this.taskPublisherName=userName;
        this.taskTitle=taskTitle;
        this.taskInfo=taskInfo;
        this.taskBonus=taskBonus;
        this.taskType=taskType;
        this.taskPublishTime=publishTime;
        this.taskEndTime=endTime;
    }

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
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
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
    public String getTaskBeginTime() {
        return taskBeginTime;
    }

    public void setTaskBeginTime(String taskBeginTime) {
        this.taskBeginTime = taskBeginTime;
    }

    @Basic
    @Column(name = "task_end_time")
    public String getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    @Basic
    @Column(name = "task_publish_time")
    public String getTaskPublishTime() {
        return taskPublishTime;
    }

    public void setTaskPublishTime(String taskPublishTime) {
        this.taskPublishTime = taskPublishTime;
    }

    @Basic
    @Column(name = "task_publisher_name")
    public String getTaskPublisherName() {
        return taskPublisherName;
    }

    public void setTaskPublisherName(String taskPublisherName) {
        this.taskPublisherName = taskPublisherName;
    }

    @Basic
    @Column(name = "task_executor_name")
    public String getTaskExecutorName() {
        return taskExecutorName;
    }

    public void setTaskExecutorName(String taskExecutorName) {
        this.taskExecutorName = taskExecutorName;
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
                Objects.equals(taskTitle, that.taskTitle) &&
                Objects.equals(taskInfo, that.taskInfo) &&
                Objects.equals(taskType, that.taskType) &&
                Objects.equals(taskBonus, that.taskBonus) &&
                Objects.equals(taskBeginTime, that.taskBeginTime) &&
                Objects.equals(taskEndTime, that.taskEndTime) &&
                Objects.equals(taskPublishTime, that.taskPublishTime) &&
                Objects.equals(taskPublisherName, that.taskPublisherName) &&
                Objects.equals(taskExecutorName, that.taskExecutorName) &&
                Objects.equals(taskStatus, that.taskStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskTitle, taskInfo, taskType, taskBonus, taskBeginTime, taskEndTime, taskPublishTime, taskPublisherName, taskExecutorName, taskStatus);
    }
}
