package com.itdev.mapper.read;

import com.itdev.database.entity.Comment;
import com.itdev.database.entity.Task;
import com.itdev.dto.read.AuthorReadDto;
import com.itdev.dto.read.ExecutorReadDto;
import com.itdev.dto.read.TaskReadDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskReadMapper implements Mapper<Task, TaskReadDto> {

    private final CommentReadMapper commentReadMapper;

    @Override
    public TaskReadDto map(Task object) {
        return new TaskReadDto(
                object.getId(),
                object.getTitle(),
                object.getDescription(),
                object.getStatus(),
                object.getPriority(),
                object.getTaskAuthor().getId(),
                object.getTaskExecutor().getId(),
                object.getComments().stream()
                        .map(commentReadMapper::map)
                        .toList()
        );
    }
}
