package br.com.like.resources;

import br.com.like.domains.Question;
import br.com.like.dtos.QuestionDto;
import br.com.like.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionResource {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/findByProduct")
    private ResponseEntity<?> getAll(@RequestParam("product") Long productId) {
        List<Question> questions = questionService.findByProduct(productId);
        return ResponseEntity.ok(QuestionDto.convertList(questions));
    }
}
