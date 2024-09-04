package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.datasource.person.AddressRepostory;
import br.com.fiap.javaChallenge.domainmodel.person.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepostory repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address save(Address a) {return this.repo.save(a);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Address a) {this.repo.delete(a);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Address> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Address> findAllAddress() {return this.repo.findAll();}

}
