package com.itdev.dto.create_edit;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@FieldNameConstants
public class CommentCreateEditDto {

    @NotBlank
    String text;

    @NotNull
    Long taskId;
}