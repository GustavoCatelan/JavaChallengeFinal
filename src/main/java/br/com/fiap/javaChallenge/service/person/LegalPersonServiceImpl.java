package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.LegalPersonRepository;
import br.com.fiap.javaChallenge.domainmodel.person.LegalPerson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LegalPersonServiceImpl implements LegalPersonService {

    private LegalPersonRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public LegalPerson save(LegalPerson lP) {return this.repo.save(lP);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final LegalPerson lP) {this.repo.delete(lP);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<LegalPerson> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<LegalPerson> findAllLegalPerson() {return this.repo.findAll();}
}
