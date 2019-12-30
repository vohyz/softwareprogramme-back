package com.example.backend.dao;

import com.example.backend.entity.TaskDraftInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDraftInfoDAO extends JpaRepository<TaskDraftInfoDAO,Integer> {
    List<TaskDraftInfoEntity> findByCreator(int id);
    TaskDraftInfoEntity findById(int id);
    TaskDraftInfoEntity save(TaskDraftInfoEntity taskDraftInfoEntity);
}
