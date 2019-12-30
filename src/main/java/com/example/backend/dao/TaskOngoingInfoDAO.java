package com.example.backend.dao;

import com.example.backend.entity.TaskOngoingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskOngoingInfoDAO extends JpaRepository<TaskOngoingInfoEntity,Integer> {
}
