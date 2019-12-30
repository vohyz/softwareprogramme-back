package com.example.backend.dao;

import com.example.backend.entity.TaskEntity;
import com.example.backend.entity.TaskPublishedEntity;
import com.example.backend.entity.TaskPublishedInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskPublishedInfoDAO extends JpaRepository<TaskPublishedInfoEntity,Integer> {
    @Query(value = "select t.publishtime, t.id " +
            "from taskPublishedInfo t where t.publisher=?1",nativeQuery = true)
    List<TaskPublishedInfoEntity> findByTaskPunlisherNameOnOmit(String taskPN);

    @Query(value = "select t.publishtime, t.id, t.title, t.bonus, t.begin_time, t.end_time " +
            "from taskPublishedInfo t where t.tags like %?1%",nativeQuery = true)
    List<TaskPublishedInfoEntity> findByTagsonomit(String tags);

    @Query(value = "select t.publishtime, t.id, t.title " +
            "from taskPublishedInfo t where t.tags like %?1% or t.title like %?1% or t.info like %?1%",nativeQuery = true)
    List<TaskPublishedInfoEntity> Search(String keyword);

    List<TaskPublishedInfoEntity> findById(int id);


}
