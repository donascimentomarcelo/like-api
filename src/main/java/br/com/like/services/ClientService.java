package br.com.like.services;

import br.com.like.domains.Client;

public interface ClientService {
    Client findByEmail(final String email);

    Client findByCpf(final String cpf);

    Client create(final Client client);
}
