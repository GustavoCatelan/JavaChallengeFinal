package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.Distributor;

import java.util.List;

public interface DistributorService {

    Distributor save(Distributor d);

    void delete(Distributor d);

    void deleteById(long id);

    List<Distributor> findAllDistributor();


}
