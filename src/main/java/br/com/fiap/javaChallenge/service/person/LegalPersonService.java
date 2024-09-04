package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.LegalPerson;

import java.util.List;

public interface LegalPersonService {

    LegalPerson save(LegalPerson lP);

    void delete(LegalPerson lP);

    void deleteById(long id);

    List<LegalPerson> findAllLegalPerson();
}
