package com.itdev.service;

import com.itdev.database.dao.repositories.CommentRepository;
import com.itdev.dto.create_edit.CommentCreateEditDto;
import com.itdev.dto.read.CommentReadDto;
import com.itdev.mapper.create_edit.CommentCreateEditMapper;
import com.itdev.mapper.read.CommentReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentReadMapper commentReadMapper;
    private final CommentCreateEditMapper commentCreateEditMapper;
    private final CommentRepository commentRepository;

    public Optional<CommentReadDto> findById(Long id) {
        return commentRepository.findById(id)
                .map(commentReadMapper::map);
    }

    public List<CommentReadDto> findByTaskId(Long id) {
        return commentRepository.findByTaskId(id).stream()
                .map(commentReadMapper::map)
                .toList();
    }

    public List<CommentReadDto> findAllByTaskIds(List<Long> ids) {
        return commentRepository.findAllByTaskIds(ids).stream()
                .map(commentReadMapper::map)
                .toList();
    }

    @Transactional
    public CommentReadDto create(CommentCreateEditDto commentDto) {
        return Optional.of(commentDto)
                .map(commentCreateEditMapper::map)
                .map(commentRepository::save)
                .map(commentReadMapper::map)
                .orElseThrow();
    }
}
