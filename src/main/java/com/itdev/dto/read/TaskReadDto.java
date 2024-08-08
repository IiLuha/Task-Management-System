package com.itdev.dto.read;

import com.itdev.database.entity.enums.Priority;
import com.itdev.database.entity.enums.Status;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Value
@FieldNameConstants
public class TaskReadDto {

    Long id;
    String title;
    String description;
    Status status;
    Priority priority;
    Long authorId;
    Long executorId;
    List<CommentReadDto> comments;
}
