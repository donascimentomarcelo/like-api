package br.com.like.dtos;

import br.com.like.domains.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String name;
    private String lastName;
    private String email;
    private String cpf;
    private Address address;
    private Set<String> phones = new HashSet<>();
    private Set<Integer> profiles = new HashSet<>();
    private AddressDto addressDto;
}
