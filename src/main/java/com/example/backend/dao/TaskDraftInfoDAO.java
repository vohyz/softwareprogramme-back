package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDraftInfoDAO extends JpaRepository<TaskDraftInfoDAO,Integer> {
}
