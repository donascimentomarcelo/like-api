package br.com.like.services.impl;

import br.com.like.domains.Comment;
import br.com.like.repositories.CommentRepository;
import br.com.like.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findByProduct(final Long productId) {
        return commentRepository.findByProductId(productId);
    }
}
