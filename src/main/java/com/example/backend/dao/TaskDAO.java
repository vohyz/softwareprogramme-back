package com.example.backend.dao;

import com.example.backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDAO extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findByTaskPublisherId(String )
}
