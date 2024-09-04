package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.Person;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {

    Person save(Person p);

    void delete(Person p);

    void deleteById(long id);

    List<Person> findAllPerson();
}
