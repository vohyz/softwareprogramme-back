package com.example.backend.dao;

import com.example.backend.entity.TaskPublishedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPublishedInfoDAO extends JpaRepository<TaskPublishedEntity,Integer> {
}
