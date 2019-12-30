package com.example.backend.dao;

import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.TaskPublishedInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskPublishedInfoDAO extends JpaRepository<TaskPublishedInfoEntity,Integer> {
    @Query(value = "select t.publishtime, t.id " +
            "from taskPublishedInfo t where t.publisher=?1",nativeQuery = true)
    List<TaskEntity> findByTaskPunlisherNameOnOmit(String taskPN);

    List<TaskEntity> findById(int id);
}
