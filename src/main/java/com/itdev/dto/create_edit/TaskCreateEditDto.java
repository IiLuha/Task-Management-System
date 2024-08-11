package com.itdev.dto.create_edit;

import com.itdev.database.entity.enums.Priority;
import com.itdev.database.entity.enums.Status;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
@FieldNameConstants
public class TaskCreateEditDto {

    @Size(max = 255)
    @NotBlank
    String title;

    @NotBlank
    String description;

    @NotNull
    Status status;

    @NotNull
    Priority priority;

    @NotNull
    Long authorId;

    @NotNull
    Long executorId;
}