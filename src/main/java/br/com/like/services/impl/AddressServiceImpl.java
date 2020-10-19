package br.com.like.services.impl;

import br.com.like.domains.Address;
import br.com.like.repositories.AddressRepository;
import br.com.like.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(final Address address) {
        return addressRepository.save(address);
    }
}
