package com.itdev.mapper.create_edit;

import com.itdev.database.dao.repositories.TaskAuthorRepository;
import com.itdev.database.dao.repositories.TaskExecutorRepository;
import com.itdev.database.dao.repositories.UserRepository;
import com.itdev.database.entity.Task;
import com.itdev.dto.create_edit.TaskCreateEditDto;
import com.itdev.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskCreateEditMapper implements Mapper<TaskCreateEditDto, Task> {

    private final TaskAuthorRepository authorRepository;
    private final TaskExecutorRepository executorRepository;

    @Override
    public Task map(TaskCreateEditDto fromObject, Task toObject) {
        toObject.setTitle(fromObject.getTitle());
        toObject.setDescription(fromObject.getDescription());
        toObject.setStatus(fromObject.getStatus());
        toObject.setPriority(fromObject.getPriority());
        toObject.setTaskAuthor(authorRepository.findById(fromObject.getAuthorId()).orElseThrow());
        toObject.setTaskExecutor(executorRepository.findById(fromObject.getExecutorId()).orElseThrow());
        return toObject;
    }

    @Override
    public Task map(TaskCreateEditDto object) {
        Task author = new Task();
        map(object, author);
        return author;
    }
}
