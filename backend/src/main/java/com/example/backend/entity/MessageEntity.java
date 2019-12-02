package com.example.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "test1", catalog = "")
public class MessageEntity {
    private int mId;
    private String mMessage;
    private Timestamp mTime;

    @Id
    @Column(name = "m_id")
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @Basic
    @Column(name = "m_message")
    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    @Basic
    @Column(name = "m_time")
    public Timestamp getmTime() {
        return mTime;
    }

    public void setmTime(Timestamp mTime) {
        this.mTime = mTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return mId == that.mId &&
                Objects.equals(mMessage, that.mMessage) &&
                Objects.equals(mTime, that.mTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mMessage, mTime);
    }
}
