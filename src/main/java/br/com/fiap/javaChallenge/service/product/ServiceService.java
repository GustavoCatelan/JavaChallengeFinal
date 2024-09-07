package br.com.fiap.javaChallenge.service.product;

import br.com.fiap.javaChallenge.domainmodel.product.Service;

import java.util.List;

public interface ServiceService {

    Service save(Service s);

    void delete(Service s);

    void deleteById(long id);

    List<Service> findAllService();
}
