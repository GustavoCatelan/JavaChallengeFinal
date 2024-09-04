package br.com.fiap.javaChallenge.service.person;



import br.com.fiap.javaChallenge.domainmodel.person.Address;

import java.util.List;

public interface AddressService {
    Address save(Address a);

    void delete(Address a);

    void deleteById(long id);

    List<Address> findAllAddress();
}
