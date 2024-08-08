package com.itdev.mapper.read;

import com.itdev.database.entity.User;
import com.itdev.dto.read.ExecutorReadDto;
import com.itdev.dto.read.AuthorReadDto;
import com.itdev.dto.read.UserReadDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final AuthorReadMapper authorReadMapper;
    private final ExecutorReadMapper executorReadMapper;

    @Override
    public UserReadDto map(User object) {
        AuthorReadDto author = Optional.ofNullable(object.getTaskAuthor()).map(authorReadMapper::map).orElse(null);
        ExecutorReadDto executor = Optional.ofNullable(object.getTaskExecutor()).map(executorReadMapper::map).orElse(null);
        return new UserReadDto(
                object.getId(),
                object.getEmail(),
                object.getPassword(),
                author,
                executor
        );
    }
}
