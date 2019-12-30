package com.example.backend.dao;

import com.example.backend.entity.TaskDraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskDraftDAO extends JpaRepository<TaskDraftEntity,Integer> {
    @Query(value = "select t.id, t.task_type, t.task_begin_time, t.task_end_time, t.task_addtime " +
            "from Task as t where t.creator=?1",nativeQuery = true)
    List<TaskDraftEntity> findByCreator(int id);

    TaskDraftEntity save(TaskDraftEntity draft);
    TaskDraftEntity findById(int id);
}
