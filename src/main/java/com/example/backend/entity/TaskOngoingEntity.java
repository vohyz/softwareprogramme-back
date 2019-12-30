package com.example.backend.entity;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TaskOngoing", schema = "SE-Platform", catalog = "")
public class TaskOngoingEntity {
    private int taskId;
    private Integer publisher;
    private DateTime publishtime;
    private Integer receiver;
    private DateTime receivetime;

    @Basic
    @Column(name = "task_id")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Id
    @Column(name = "publisher")
    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "publishtime")
    public DateTime getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(DateTime publishtime) {
        this.publishtime = publishtime;
    }

    @Basic
    @Column(name = "receiver")
    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "receivetime")
    public DateTime getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(DateTime receivetime) {
        this.receivetime = receivetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskOngoingEntity that = (TaskOngoingEntity) o;

        if (taskId != that.taskId) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (publishtime != null ? !publishtime.equals(that.publishtime) : that.publishtime != null) return false;
        if (receiver != null ? !receiver.equals(that.receiver) : that.receiver != null) return false;
        if (receivetime != null ? !receivetime.equals(that.receivetime) : that.receivetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (publishtime != null ? publishtime.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (receivetime != null ? receivetime.hashCode() : 0);
        return result;
    }
}
