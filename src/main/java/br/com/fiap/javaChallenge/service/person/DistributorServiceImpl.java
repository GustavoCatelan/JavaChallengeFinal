package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.DistributorRepository;
import br.com.fiap.javaChallenge.domainmodel.person.Distributor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DistributorServiceImpl implements DistributorService {

    private DistributorRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Distributor save(Distributor d) {return this.repo.save(d);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Distributor d) {this.repo.delete(d);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Distributor> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Distributor> findAllDistributor () {return this.repo.findAll();}
}
