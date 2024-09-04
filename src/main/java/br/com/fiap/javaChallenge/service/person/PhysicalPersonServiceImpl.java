package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.PhysicalPersonRepository;
import br.com.fiap.javaChallenge.domainmodel.person.PhysicalPerson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PhysicalPersonServiceImpl implements PhysicalPersonService {

    private PhysicalPersonRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PhysicalPerson save(PhysicalPerson pP) {return this.repo.save(pP);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final PhysicalPerson pP) {this.repo.delete(pP);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<PhysicalPerson> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<PhysicalPerson> findAllPhysicalPerson() {return this.repo.findAll();}
}
