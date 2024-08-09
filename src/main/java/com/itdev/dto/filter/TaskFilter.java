package com.itdev.dto.filter;

import com.itdev.database.entity.enums.Priority;
import com.itdev.database.entity.enums.Status;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
public record TaskFilter(String title, String description, Status status,
                         Priority priority, Long taskAuthorId, Long taskExecutorId) {
    @Builder
    public TaskFilter {
    }
}
