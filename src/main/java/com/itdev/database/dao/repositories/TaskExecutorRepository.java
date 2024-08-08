package com.itdev.database.dao.repositories;

import com.itdev.database.entity.TaskExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskExecutorRepository extends JpaRepository<TaskExecutor, Long> {
}
