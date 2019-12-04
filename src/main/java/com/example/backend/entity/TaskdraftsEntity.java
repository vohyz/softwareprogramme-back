package com.example.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Taskdrafts", schema = "SE-Platform", catalog = "")
public class TaskdraftsEntity {
    private int id;
    private Integer taskCreator;
    private Integer taskType;
    private String taskInfo;
    private Double taskBonus;
    private String taskBeginTime;
    private String taskEndTime;
    private String taskAddtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task_creator")
    public Integer getTaskCreator() {
        return taskCreator;
    }

    public void setTaskCreator(Integer taskCreator) {
        this.taskCreator = taskCreator;
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
    @Column(name = "task_addtime")
    public String getTaskAddtime() {
        return taskAddtime;
    }

    public void setTaskAddtime(String taskAddtime) {
        this.taskAddtime = taskAddtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskdraftsEntity that = (TaskdraftsEntity) o;
        return id == that.id &&
                Objects.equals(taskCreator, that.taskCreator) &&
                Objects.equals(taskType, that.taskType) &&
                Objects.equals(taskInfo, that.taskInfo) &&
                Objects.equals(taskBonus, that.taskBonus) &&
                Objects.equals(taskBeginTime, that.taskBeginTime) &&
                Objects.equals(taskEndTime, that.taskEndTime) &&
                Objects.equals(taskAddtime, that.taskAddtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskCreator, taskType, taskInfo, taskBonus, taskBeginTime, taskEndTime, taskAddtime);
    }
}
