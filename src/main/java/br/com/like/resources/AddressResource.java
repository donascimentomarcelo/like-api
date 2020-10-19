package br.com.like.resources;

import br.com.like.domains.Address;
import br.com.like.dtos.AddressDto;
import br.com.like.services.AddressService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/adresses")
public class AddressResource {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final AddressDto dto) {
        Address address = addressService.create(dto.fromEntity());

        URI uri = Util.getUri(address.getId());
        return ResponseEntity.created(uri).build();
    }
}
