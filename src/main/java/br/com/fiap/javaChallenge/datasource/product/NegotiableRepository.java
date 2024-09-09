package br.com.fiap.javaChallenge.datasource.product;

import br.com.fiap.javaChallenge.domainmodel.product.Negotiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegotiableRepository extends JpaRepository<Negotiable, Long> {
}
