package com.example.backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Message", schema = "SE-Platform", catalog = "")
public class MessageEntity {
    private int mId;
    private String mMessage;
    private Timestamp mTime;
    private Integer mDatatype;
    private Integer mFromUser;
    private Integer mToUser;

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

    @Basic
    @Column(name = "m_datatype")
    public Integer getmDatatype() {
        return mDatatype;
    }

    public void setmDatatype(Integer mDatatype) {
        this.mDatatype = mDatatype;
    }

    @Basic
    @Column(name = "m_fromUser")
    public Integer getmFromUser() {
        return mFromUser;
    }

    public void setmFromUser(Integer mFromUser) {
        this.mFromUser = mFromUser;
    }

    @Basic
    @Column(name = "m_toUser")
    public Integer getmToUser() {
        return mToUser;
    }

    public void setmToUser(Integer mToUser) {
        this.mToUser = mToUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return mId == that.mId &&
                Objects.equals(mMessage, that.mMessage) &&
                Objects.equals(mTime, that.mTime) &&
                Objects.equals(mDatatype, that.mDatatype) &&
                Objects.equals(mFromUser, that.mFromUser) &&
                Objects.equals(mToUser, that.mToUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mMessage, mTime, mDatatype, mFromUser, mToUser);
    }
}
