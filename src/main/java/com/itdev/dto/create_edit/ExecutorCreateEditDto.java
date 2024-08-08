package com.itdev.dto.create_edit;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotNull;

@Value
@FieldNameConstants
public class ExecutorCreateEditDto {

    @NotNull
    Long userId;
}
