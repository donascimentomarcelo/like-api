package br.com.like.services;

import br.com.like.domains.User;

public interface UserService {
    User create(final User user);

    User findByUsername(final String username);

    void delete(Long id);
}
