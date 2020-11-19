package br.com.like.dtos;

import br.com.like.annotations.UsernameValidation;
import br.com.like.domains.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@UsernameValidation
public class UserDto {

    private String username;
    private String password;

    public User fromEntity() {
        return new User(getUsername(), getPassword());
    }
}
