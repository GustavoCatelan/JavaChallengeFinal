package br.com.fiap.javaChallenge.datasource.product;

import br.com.fiap.javaChallenge.domainmodel.product.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
