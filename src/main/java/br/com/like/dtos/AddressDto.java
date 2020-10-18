package br.com.like.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String zipcode;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;
}
