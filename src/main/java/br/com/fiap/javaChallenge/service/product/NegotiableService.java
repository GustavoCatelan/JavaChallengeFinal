package br.com.fiap.javaChallenge.service.product;

import br.com.fiap.javaChallenge.domainmodel.product.Negotiable;

import java.util.List;

public interface NegotiableService {

    Negotiable save(Negotiable n);

    void delete(Negotiable n);

    void deleteById(long id);

    List<Negotiable> findAllNegotiable();
}
