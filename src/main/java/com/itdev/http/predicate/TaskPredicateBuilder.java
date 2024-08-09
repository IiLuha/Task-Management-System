package com.itdev.http.predicate;

import com.itdev.database.entity.QTask;
import com.itdev.dto.filter.TaskFilter;
import com.itdev.http.predicate.QPredicate;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskPredicateBuilder {

    public static Predicate buildPredicate(TaskFilter filter) {
        return QPredicate.builder()
                .add(filter.title(), QTask.task.title::containsIgnoreCase)
                .add(filter.description(), QTask.task.description::containsIgnoreCase)
                .add(filter.status(), QTask.task.status::eq)
                .add(filter.priority(), QTask.task.priority::eq)
                .add(filter.taskAuthorId(), QTask.task.taskAuthor.id::eq)
                .add(filter.taskExecutorId(), QTask.task.taskExecutor.id::eq)
                .buildAnd();
    }
}
