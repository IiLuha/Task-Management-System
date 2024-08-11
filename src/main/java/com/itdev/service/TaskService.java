package com.itdev.service;

import com.itdev.http.predicate.TaskPredicateBuilder;
import com.itdev.database.dao.repositories.TaskRepository;
import com.itdev.dto.create_edit.TaskCreateEditDto;
import com.itdev.dto.filter.TaskFilter;
import com.itdev.dto.read.TaskReadDto;
import com.itdev.mapper.create_edit.TaskCreateEditMapper;
import com.itdev.mapper.read.TaskReadMapper;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskReadMapper taskReadMapper;
    private final TaskCreateEditMapper taskCreateEditMapper;
    private final TaskRepository taskRepository;

    public Page<TaskReadDto> findAll(TaskFilter filter, Pageable pageable) {
        Predicate predicate = TaskPredicateBuilder.buildPredicate(filter);
        return taskRepository.findAll(predicate, pageable)
                .map(taskReadMapper::map);
    }

    public Optional<TaskReadDto> findById(Long id) {
        return taskRepository.findById(id)
                .map(taskReadMapper::map);
    }

    @Transactional
    public TaskReadDto create(TaskCreateEditDto taskDto) {
        return Optional.of(taskDto)
                .map(taskCreateEditMapper::map)
                .map(taskRepository::save)
                .map(taskReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<TaskReadDto> update(Long id, TaskCreateEditDto taskDto) {
        return taskRepository.findById(id)
                .map(entity -> taskCreateEditMapper.map(taskDto, entity))
                .map(taskRepository::saveAndFlush)
                .map(taskReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return taskRepository.findById(id)
                .map(entity -> {
                    taskRepository.delete(entity);
                    taskRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
