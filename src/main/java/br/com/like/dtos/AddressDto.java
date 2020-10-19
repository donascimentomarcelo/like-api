package br.com.like.dtos;

import br.com.like.annotations.ZipcodeValidation;
import br.com.like.domains.Address;
import br.com.like.domains.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ZipcodeValidation
public class AddressDto {

    @NotNull(message = "CEP obrigatório")
    private String zipcode;

    @NotNull(message = "Rua obrigatória")
    private String street;

    @NotNull(message = "Bairro obrigatório")
    private String neighborhood;

    @NotNull(message = "Complemento obrigatório")
    private String complement;

    @NotNull(message = "Cidade obrigatório")
    private String city;

    @NotNull(message = "Estado obrigatório")
    private String state;

    @NotNull(message = "Cliente não informado")
    private Long clientId;

    public Address fromEntity() {
        Client client = new Client(clientId);
        return new Address(null, getZipcode(), getStreet(), getNeighborhood(), getComplement(), getCity(), getState(), client);
    }
}
