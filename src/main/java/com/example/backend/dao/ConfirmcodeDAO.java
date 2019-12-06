package com.example.backend.dao;

import com.example.backend.entity.ConfirmcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ConfirmcodeDAO extends JpaRepository<ConfirmcodeEntity,Integer> {
    List<ConfirmcodeEntity> findByUserPhone(String phone);
    ConfirmcodeEntity save(ConfirmcodeEntity confirmcodeEntity);
}
