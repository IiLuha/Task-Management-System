package com.itdev.mapper.create_edit;

import com.itdev.database.dao.repositories.TaskRepository;
import com.itdev.database.entity.Comment;
import com.itdev.dto.create_edit.CommentCreateEditDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentCreateEditMapper implements Mapper<CommentCreateEditDto, Comment> {

    private final TaskRepository taskRepository;

    @Override
    public Comment map(CommentCreateEditDto fromObject, Comment toObject) {
        toObject.setText(fromObject.getText());
        toObject.setTask(taskRepository.findById(fromObject.getTaskId()).orElseThrow());
        return toObject;
    }

    @Override
    public Comment map(CommentCreateEditDto object) {
        Comment author = new Comment();
        map(object, author);
        return author;
    }
}
