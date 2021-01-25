package br.com.like.resources;

import br.com.like.domains.Comment;
import br.com.like.dtos.CommentDto;
import br.com.like.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentResource {

    @Autowired
    private CommentService commmentService;

    @GetMapping("/findByProduct")
    private ResponseEntity<List<CommentDto>> findByProduct(@RequestParam("product") Long productId) {
        List<Comment> comments = commmentService.findByProduct(productId);
        return ResponseEntity.ok(CommentDto.convertList(comments));
    }
}
