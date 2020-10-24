package br.com.like.services.impl;

import br.com.like.domains.User;
import br.com.like.repositories.UserRepository;
import br.com.like.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
