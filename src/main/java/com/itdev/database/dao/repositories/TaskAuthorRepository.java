package com.itdev.database.dao.repositories;

import com.itdev.database.entity.TaskAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAuthorRepository extends JpaRepository<TaskAuthor, Long> {
}
