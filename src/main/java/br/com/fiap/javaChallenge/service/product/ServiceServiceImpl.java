package br.com.fiap.javaChallenge.service.product;

import br.com.fiap.javaChallenge.datasource.product.ServiceRepository;
import br.com.fiap.javaChallenge.domainmodel.product.Service;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Service save(Service s) {return this.repo.save(s);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Service s) {this.repo.delete(s);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Service> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Service> findAllService() {return this.repo.findAll();}

}
