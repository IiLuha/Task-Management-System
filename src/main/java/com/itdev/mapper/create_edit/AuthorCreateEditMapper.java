package com.itdev.mapper.create_edit;

import com.itdev.database.dao.repositories.UserRepository;
import com.itdev.database.entity.TaskAuthor;
import com.itdev.dto.create_edit.AuthorCreateEditDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorCreateEditMapper implements Mapper<AuthorCreateEditDto, TaskAuthor> {

    private final UserRepository userRepository;

    @Override
    public TaskAuthor map(AuthorCreateEditDto fromObject, TaskAuthor toObject) {
        toObject.setUser(userRepository.findById(fromObject.getUserId()).orElseThrow());
        return toObject;
    }

    @Override
    public TaskAuthor map(AuthorCreateEditDto object) {
        TaskAuthor author = new TaskAuthor();
        map(object, author);
        return author;
    }
}
