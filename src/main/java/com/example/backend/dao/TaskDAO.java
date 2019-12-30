package com.example.backend.dao;

import com.example.backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskDAO extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findByTaskId(int taskId);

    @Query(value = "select t.publish_time, t.task_status, t.task_id, t.task_title" +
            "from Task t where t.task_type like %?1% or t.task_title like %?1% or t.task_info like %?1%",nativeQuery = true)
    List<TaskEntity> Search(String keyword);
}
