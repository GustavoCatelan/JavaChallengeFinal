package br.com.fiap.javaChallenge.service.product;

import br.com.fiap.javaChallenge.datasource.product.NegotiableRepository;
import br.com.fiap.javaChallenge.domainmodel.product.Negotiable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NegotiableServiceImpl implements NegotiableService {

    private NegotiableRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Negotiable save(Negotiable n) {return this.repo.save(n);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Negotiable n) {this.repo.delete(n);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Negotiable> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Negotiable> findAllNegotiable() {return this.repo.findAll();}
}
