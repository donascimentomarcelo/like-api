package br.com.like.services.impl;

import br.com.like.constants.Constants;
import br.com.like.domains.User;
import br.com.like.exceptions.models.ObjectNotFoundException;
import br.com.like.repositories.UserRepository;
import br.com.like.security.models.UserSpringSecurity;
import br.com.like.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User create(final User user) {
        encodePassword(user);
        return userRepository.save(user);
    }

    private void encodePassword(final User user) {
        final String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
    }

    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username)
                    .orElseThrow(() -> new ObjectNotFoundException(Constants.USER_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        } catch (Exception e) {
            return null;

        }
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = findByUsername(username);
        return new UserSpringSecurity(user.getId(), user.getUsername(), user.getPassword(), user.getProfiles());
    }
}
