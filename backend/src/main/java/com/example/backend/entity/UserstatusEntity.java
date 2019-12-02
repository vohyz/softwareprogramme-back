package com.example.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userstatus", schema = "test1", catalog = "")
public class UserstatusEntity {
    private int userId;
    private String userStatus;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_status")
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserstatusEntity that = (UserstatusEntity) o;
        return userId == that.userId &&
                Objects.equals(userStatus, that.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userStatus);
    }
}
