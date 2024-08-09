package com.itdev.http.rest;

import com.itdev.dto.PageResponse;
import com.itdev.dto.create_edit.CommentCreateEditDto;
import com.itdev.dto.read.CommentReadDto;
import com.itdev.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

//    @GetMapping("/roles")
//    public Role[] getRoles() {
//        return Role.values();
//    }

    @GetMapping("/{id}")
    public CommentReadDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/task/{id}")
    public List<CommentReadDto> findAllByTaskId(@PathVariable("id") Long taskId) {
        return commentService.findByTaskId(taskId);
    }

    @GetMapping("/tasks")
    public List<CommentReadDto> findAllByTaskIds(@RequestBody List<Long> taskIds) {
        return commentService.findByTaskIds(taskIds);
    }
//
//    @GetMapping("/{id}/image")
//    public ResponseEntity<byte[]> findImage(@PathVariable("id") Integer id) {
//        return commentService.findImage(id)
//                .map(content -> ResponseEntity.ok()
//                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
//                        .contentLength(content.length)
//                        .body(content))
//                .orElseGet(notFound()::build);
//    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentReadDto create(@Validated @RequestBody CommentCreateEditDto comment) {
        return commentService.create(comment);
    }

//    @PutMapping("/{id}")
//    public CommentReadDto update(@PathVariable("id") Integer id, @Validated @RequestBody CommentCreateEditDto comment) {
//        return commentService.update(id, comment)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
//        return commentService.delete(id)
//                ? noContent().build()
//                : notFound().build();
//    }
}
