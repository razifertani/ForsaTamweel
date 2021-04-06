package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.TransactionTemplate;

import java.util.List;

public interface TransactionTemplateRepository extends JpaRepository<TransactionTemplate, Long> {

    List<TransactionTemplate> findAllByUser_Identifier(String identifier);
}
