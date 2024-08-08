package com.itdev.dto.read;

import lombok.Value;
import lombok.experimental.FieldNameConstants;


@Value
@FieldNameConstants
public class UserReadDto {

    Long id;
    String email;
    String password;
    AuthorReadDto taskAuthor;
    ExecutorReadDto taskExecutor;
}
