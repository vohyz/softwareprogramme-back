package com.example.backend.dao;

import com.example.backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskDAO extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findByTaskPublisherName(String taskPN);
    List<TaskEntity> findByTaskExecutorName(String taskEN);
    List<TaskEntity> findByTaskExecutorNameAndTaskStatus(String taskEN,String taskStatus);
    List<TaskEntity> findByTaskId(int taskId);

    @Query(value = "select t.publish_time, t.task_status, t.task_executor_name, t.task_id " +
            "from Task t where t.task_executor_name=?1 and t.task_status=?2",nativeQuery = true)
    List<TaskEntity> findByTaskExecutorNameAndTaskStatusOnOmit(String taskEN,String taskStatus);

    @Query(value = "select t.publish_time, t.task_status, t.task_executor_name, t.task_id " +
            "from Task t where t.task_publisher_name=?1",nativeQuery = true)
    List<TaskEntity> findByTaskPunlisherNameOnOmit(String taskPN);

    @Query(value = "select t.publish_time, t.task_status, t.task_id, t.task_title" +
            "from Task t where t.task_type like %?1%",nativeQuery = true)
    List<TaskEntity> findByTags(String tags);

    @Query(value = "select t.publish_time, t.task_status, t.task_id, t.task_title" +
            "from Task t where t.task_type like %?1% or t.task_title like %?1% or t.task_info like %?1%",nativeQuery = true)
    List<TaskEntity> Search(String keyword);
}
