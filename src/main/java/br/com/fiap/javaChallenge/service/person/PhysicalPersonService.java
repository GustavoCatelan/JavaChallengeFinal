package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.PhysicalPerson;

import java.util.List;

public interface PhysicalPersonService {

    PhysicalPerson save(PhysicalPerson pP);

    void delete(PhysicalPerson pP);

    void deleteById(long id);

    List<PhysicalPerson> findAllPhysicalPerson();
}
