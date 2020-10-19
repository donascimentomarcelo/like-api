package br.com.like.resources;

import br.com.like.domains.User;
import br.com.like.dtos.UserDto;
import br.com.like.services.UserService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final UserDto dto) {
        User user = userService.create(dto.fromEntity());

        URI uri = Util.getUri(user.getId());
        return ResponseEntity.created(uri).build();
    }
}
