package com.itdev.database.dao.repositories;

import com.itdev.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TaskRepository extends JpaRepository<Task, Long>, QuerydslPredicateExecutor<Task> {
}
