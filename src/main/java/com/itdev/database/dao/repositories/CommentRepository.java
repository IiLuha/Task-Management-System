package com.itdev.database.dao.repositories;

import com.itdev.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTaskId(Long id);

    @Query("select c from Comment c " +
            "where c.task.id IN :ids")
    List<Comment> findAllByTaskIds(List<Long> ids);
}
