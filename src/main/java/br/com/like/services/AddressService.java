package br.com.like.services;

import br.com.like.domains.Address;

public interface AddressService {
    Address create(final Address address);

    void update(final Address address, final Long id);
}
