package com.example.backend.dao;

import com.example.backend.entity.TaskFinishedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskFinishedInfoDAO extends JpaRepository<TaskFinishedEntity,Integer> {
}
