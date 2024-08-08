package com.itdev.mapper.read;

import com.itdev.database.entity.Comment;
import com.itdev.dto.read.CommentReadDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentReadMapper implements Mapper<Comment, CommentReadDto> {

    @Override
    public CommentReadDto map(Comment object) {
        return new CommentReadDto(
                object.getId(),
                object.getText(),
                object.getTask().getId()
        );
    }
}
