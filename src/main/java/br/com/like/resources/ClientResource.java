package br.com.like.resources;

import br.com.like.domains.Client;
import br.com.like.dtos.ClientNewDto;
import br.com.like.dtos.ClientUpdateDto;
import br.com.like.services.ClientService;
import br.com.like.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final ClientNewDto dto) {
        Client client = clientService.create(dto.fromEntity());

        URI uri = Util.getUri(client.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody final ClientUpdateDto dto, final Long id) {
        clientService.update(dto.fromEntity(), id);
        return ResponseEntity.noContent().build();
    }
}
