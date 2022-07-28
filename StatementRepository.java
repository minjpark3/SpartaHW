package com.sparta.springweek01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {
    List<Statement> findAllByOrderByModifiedAtDesc();
}