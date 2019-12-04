package com.example.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Messagetype", schema = "SE-Platform", catalog = "")
public class MessagetypeEntity {
    private int mTypeId;
    private String mTypeName;

    @Id
    @Column(name = "m_type_id")
    public int getmTypeId() {
        return mTypeId;
    }

    public void setmTypeId(int mTypeId) {
        this.mTypeId = mTypeId;
    }

    @Basic
    @Column(name = "m_type_name")
    public String getmTypeName() {
        return mTypeName;
    }

    public void setmTypeName(String mTypeName) {
        this.mTypeName = mTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagetypeEntity that = (MessagetypeEntity) o;
        return mTypeId == that.mTypeId &&
                Objects.equals(mTypeName, that.mTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTypeId, mTypeName);
    }
}
