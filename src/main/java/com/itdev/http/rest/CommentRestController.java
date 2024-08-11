package com.itdev.http.rest;

import com.itdev.dto.create_edit.CommentCreateEditDto;
import com.itdev.dto.read.CommentReadDto;
import com.itdev.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public CommentReadDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/task/{id}")
    public List<CommentReadDto> findAllByTaskId(@PathVariable("id") Long taskId) {
        return commentService.findByTaskId(taskId);
    }

    @GetMapping(value = "/tasks", params = "taskIds")
    public List<CommentReadDto> findAllByTaskIds(@RequestParam List<Long> taskIds) {
        return commentService.findAllByTaskIds(taskIds);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentReadDto create(@Validated @RequestBody CommentCreateEditDto comment, BindingResult bindingResult) {
        return commentService.create(comment);
    }
}
