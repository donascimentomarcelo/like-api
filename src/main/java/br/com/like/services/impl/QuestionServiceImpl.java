package br.com.like.services.impl;

import br.com.like.domains.Question;
import br.com.like.repositories.QuestionRepository;
import br.com.like.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findByProduct(final Long productId) {
        return questionRepository.findByProductId(productId);
    }
}
