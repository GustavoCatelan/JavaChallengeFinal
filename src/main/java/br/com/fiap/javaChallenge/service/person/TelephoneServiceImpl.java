package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.TelephoneRepository;
import br.com.fiap.javaChallenge.domainmodel.person.Telephone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TelephoneServiceImpl implements TelephoneService {

    private TelephoneRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Telephone save(Telephone t) {return this.repo.save(t);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Telephone t) {this.repo.delete(t);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Telephone> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Telephone> findAllTelephone() {return this.repo.findAll();}
}
