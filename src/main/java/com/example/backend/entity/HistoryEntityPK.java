package com.example.backend.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class HistoryEntityPK implements Serializable {
    private int taskId;
    private int userId;

    @Column(name = "task_id")
    @Id
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryEntityPK that = (HistoryEntityPK) o;

        if (taskId != that.taskId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + userId;
        return result;
    }
}
