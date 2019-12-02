package com.example.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "module", schema = "test1", catalog = "")
public class ModuleEntity {
    private Integer typeId;
    private String taskType;

    @Id
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "task_type")
    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleEntity that = (ModuleEntity) o;
        return Objects.equals(typeId, that.typeId) &&
                Objects.equals(taskType, that.taskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, taskType);
    }
}
