package com.itdev.mapper.read;

import com.itdev.database.entity.TaskExecutor;
import com.itdev.dto.read.ExecutorReadDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExecutorReadMapper implements Mapper<TaskExecutor, ExecutorReadDto> {

    private final TaskReadMapper taskReadMapper;

    @Override
    public ExecutorReadDto map(TaskExecutor object) {
        return new ExecutorReadDto(
                object.getId(),
                object.getUser().getId(),
                object.getTasks().stream()
                        .map(taskReadMapper::map)
                        .toList()
        );
    }
}
