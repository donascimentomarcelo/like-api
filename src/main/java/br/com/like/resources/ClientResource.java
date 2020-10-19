package br.com.like.resources;

import br.com.like.domains.Client;
import br.com.like.dtos.ClientDto;
import br.com.like.services.ClientService;
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
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final ClientDto dto) {
        Client client = clientService.create(dto.fromEntity());

        URI uri = Util.getUri(client.getId());
        return ResponseEntity.created(uri).build();
    }
}
