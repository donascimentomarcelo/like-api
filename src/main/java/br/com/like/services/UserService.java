package br.com.like.services;

import br.com.like.domains.User;
import br.com.like.security.models.UserSpringSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User create(final User user);

    User findByUsername(final String username);

    void delete(final Long id);

    UserSpringSecurity authenticated();
}
