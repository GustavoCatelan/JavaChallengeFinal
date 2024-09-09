package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.PersonRepository;
import br.com.fiap.javaChallenge.domainmodel.person.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Person save(Person p) {return this.repo.save(p);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Person p) {this.repo.delete(p);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Person> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Person> findAllPerson() {return this.repo.findAll();}
}
