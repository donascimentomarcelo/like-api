package br.com.like.dtos;

import br.com.like.annotations.UsernameValidation;
import br.com.like.domains.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@UsernameValidation
public class UserDto {

    @NotNull(message = "O campo não pode ser nulo!")
    private String username;

    @NotNull(message = "O campo não pode ser nulo!")
    private String password;

    public static UserDto fromDto(final User user) {
        return user != null ?
            new UserDto(user.getUsername(), user.getPassword()) :
            null;
    }

    public User fromEntity() {
        return new User(getUsername(), getPassword());
    }
}
