package com.itdev.dto.read;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@FieldNameConstants
public class CommentReadDto {

    Long id;
    String text;
    Long taskId;
}
