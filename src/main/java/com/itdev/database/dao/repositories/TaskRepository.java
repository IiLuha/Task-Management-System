package com.itdev.database.dao.repositories;

import com.itdev.database.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
