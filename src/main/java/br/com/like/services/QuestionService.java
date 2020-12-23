package br.com.like.services;

import br.com.like.domains.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findByProduct(final Long productId);
}
