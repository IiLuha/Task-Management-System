package com.itdev.mapper.read;

import com.itdev.database.entity.Task;
import com.itdev.database.entity.TaskAuthor;
import com.itdev.dto.read.AuthorReadDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
@RequiredArgsConstructor
public class AuthorReadMapper implements Mapper<TaskAuthor, AuthorReadDto> {

    private final TaskReadMapper taskReadMapper;

    @Override
    public AuthorReadDto map(TaskAuthor object) {
        return new AuthorReadDto(
                object.getId(),
                object.getUser().getId(),
                object.getTasks().stream()
                        .map(taskReadMapper::map)
                        .toList()
        );
    }
}
