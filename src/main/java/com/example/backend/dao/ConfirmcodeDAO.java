package com.example.backend.dao;

import com.example.backend.entity.ConfirmcodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ConfirmcodeDAO extends JpaRepository<ConfirmcodeEntity,Integer> {
    ConfirmcodeEntity findByUserPhone(String phone);
}
