package br.com.like.resources;

import br.com.like.domains.Product;
import br.com.like.domains.Question;
import br.com.like.domains.User;
import br.com.like.dtos.QuestionDto;
import br.com.like.security.models.UserSpringSecurity;
import br.com.like.services.QuestionService;
import br.com.like.services.UserService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionResource {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @GetMapping("/findByProduct")
    private ResponseEntity<?> getAll(@RequestParam("product") final Long productId) {
        List<Question> questions = questionService.findByProduct(productId);
        return ResponseEntity.ok(QuestionDto.convertList(questions));
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody final QuestionDto dto) {
        final Question question = dto.fromEntity();

        final UserSpringSecurity authenticated = userService.authenticated();
        question.setUser(new User(authenticated.getId()));

        question.setProduct(new Product(dto.getProductId()));

        questionService.save(question);

        URI uri = Util.getUri(question.getId());
        return ResponseEntity.created(uri).build();
    }
}
