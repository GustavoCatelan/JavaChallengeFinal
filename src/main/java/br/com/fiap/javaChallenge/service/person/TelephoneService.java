package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.Telephone;

import java.util.List;

public interface TelephoneService {

    Telephone save(Telephone t);

    void delete(Telephone t);

    void deleteById(long id);

    List<Telephone> findAllTelephone();
}
