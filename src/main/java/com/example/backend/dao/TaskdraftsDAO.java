package com.example.backend.dao;

import com.example.backend.entity.TaskdraftsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskdraftsDAO extends JpaRepository<TaskdraftsEntity,Integer> {
    @Query(value = "select t.id, t.task_type, t.task_begin_time, t.task_end_time, t.task_addtime " +
            "from Task as t where t.task_creator=?1",nativeQuery = true)
    List<TaskdraftsEntity> findByTaskCreator(int id);

    TaskdraftsEntity save(TaskdraftsEntity draft);
    TaskdraftsEntity findById(int id);
}
