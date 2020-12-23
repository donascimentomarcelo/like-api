package br.com.like.services;

import br.com.like.domains.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findByProduct(Long productId);
}
