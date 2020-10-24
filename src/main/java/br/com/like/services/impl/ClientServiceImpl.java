package br.com.like.services.impl;

import br.com.like.domains.Client;
import br.com.like.repositories.ClientRepository;
import br.com.like.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByEmail(final String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByCpf(final String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    @Override
    public Client create(final Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void update(Client client, Long id) {
        client.setId(id);
        clientRepository.save(client);
    }
}
