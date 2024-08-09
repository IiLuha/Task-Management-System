package com.itdev.service;

import com.itdev.database.dao.repositories.CommentRepository;
import com.itdev.dto.create_edit.CommentCreateEditDto;
import com.itdev.dto.read.CommentReadDto;
import com.itdev.mapper.create_edit.CommentCreateEditMapper;
import com.itdev.mapper.read.CommentReadMapper;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
//
    private final CommentReadMapper commentReadMapper;
    private final CommentCreateEditMapper commentCreateEditMapper;
    private final CommentRepository commentRepository;
//    private final ImageService imageService;
//
//    public Page<CommentReadDto> findAll(CommentFilter filter, Pageable pageable) {
//        Predicate predicate = FilterCommentRepositoryImpl.buildPredicate(filter);
//        return commentRepository.findAll(predicate, pageable)
//                .map(commentReadMapper::map);
//    }
//
//    public List<CommentReadDto> findAll() {
//        return commentRepository.findAll().stream()
//                .map(commentReadMapper::map)
//                .toList();
//    }

    public Optional<CommentReadDto> findById(Long id) {
        return commentRepository.findById(id)
                .map(commentReadMapper::map);
    }

    public List<CommentReadDto> findByTaskId(Long id) {
        return commentRepository.findByTaskId(id).stream()
                .map(commentReadMapper::map)
                .toList();
    }

    public List<CommentReadDto> findByTaskIds(List<Long> ids) {
        return commentRepository.findByTaskIds(ids).stream()
                .map(commentReadMapper::map)
                .toList();
    }

//    public Optional<byte[]> findImage(Integer id) {
//        return commentRepository.findById(id)
//                .map(Comment::getImage)
//                .filter(StringUtils::hasText)
//                .flatMap(imageService::download);
//    }
//
    @Transactional
    public CommentReadDto create(CommentCreateEditDto commentDto) {
        return Optional.of(commentDto)
                .map(commentCreateEditMapper::map)
                .map(commentRepository::save)
                .map(commentReadMapper::map)
                .orElseThrow();
    }
//
//    @SneakyThrows
//    private void uploadImage(MultipartFile image) {
//        if (image != null && !image.isEmpty()) {
//            imageService.upload(image.getOriginalFilename(), image.getInputStream());
//        }
//    }
//
//    @Transactional
//    public Optional<CommentReadDto> update(Integer id, CommentCreateEditDto commentDto) {
//        return commentRepository.findById(id)
//                .map(comment -> {
//                    uploadImage(commentDto.getImage());
//                    return commentCreateEditMapper.map(commentDto, comment);
//                })
//                .map(commentRepository::saveAndFlush)
//                .map(commentReadMapper::map);
//    }
//
//    @Transactional
//    public boolean delete(Integer id) {
//        return commentRepository.findById(id)
//                .map(entity -> {
//                    commentRepository.delete(entity);
//                    commentRepository.flush();
//                    return true;
//                })
//                .orElse(false);
//    }
//
//    @Override
//    public CommentDetails loadCommentByCommentname(String commentname) throws CommentnameNotFoundException {
//        return commentRepository.findByEmail(commentname)
//                .map(comment -> new org.springframework.security.core.commentdetails.Comment(
//                        comment.getEmail(),
//                        comment.getPassword(),
//                        Collections.singleton(comment.getRole())
//                ))
//                .orElseThrow(() -> new CommentnameNotFoundException("Fail to retrieve comment: " + commentname));
//    }
}
