package br.com.like.dtos;

import br.com.like.annotations.CpfValidation;
import br.com.like.annotations.EmailValidation;
import br.com.like.domains.Client;
import br.com.like.domains.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@CpfValidation
@EmailValidation
public class ClientDto {

    @NotNull(message = "Nome obrigatório")
    private String name;
    private String lastName;

    @NotNull(message = "E-mail obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    private String cpf;

    @NotNull(message = "Informe ao menos 1 telefone")
    private Set<String> phones = new HashSet<>();
    private Set<Integer> profiles = new HashSet<>();

    @NotNull(message = "Usuáro não informado")
    private Long userId;

    public Client fromEntity() {
        final User user = new User(userId);
        return new Client(name, lastName, email, cpf, phones, profiles, user);
    }
}
