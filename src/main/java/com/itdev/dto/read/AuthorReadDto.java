package com.itdev.dto.read;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Value
@FieldNameConstants
public class AuthorReadDto {

    Long id;
    Long userId;
    List<TaskReadDto> tasks;
}
