package com.itdev.database.dao.repositories;

import com.itdev.database.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTaskId(Long id);

    List<Comment> findByTaskIds(List<Long> ids);
}
