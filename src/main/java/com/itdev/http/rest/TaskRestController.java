package com.itdev.http.rest;

import com.itdev.dto.PageResponse;
import com.itdev.dto.create_edit.TaskCreateEditDto;
import com.itdev.dto.filter.TaskFilter;
import com.itdev.dto.read.TaskReadDto;
import com.itdev.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskRestController {

    private final TaskService taskService;

    @GetMapping
    public PageResponse<TaskReadDto> findAll(TaskFilter filter, Pageable pageable) {
        return PageResponse.of(taskService.findAll(filter, pageable));
    }

    @GetMapping("/{id}")
    public TaskReadDto findById(@PathVariable("id") Long id) {
        return taskService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskReadDto create(@Validated @RequestBody TaskCreateEditDto task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    public TaskReadDto update(@PathVariable Long id, @Validated @RequestBody TaskCreateEditDto task) {
        return taskService.update(id, task)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //PathVariable проверить - можно ли без value
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return taskService.delete(id)
                ? noContent().build()
                : notFound().build();
    }
}
