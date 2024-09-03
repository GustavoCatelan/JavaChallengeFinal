package br.com.fiap.javaChallenge.datasource.product;

import br.com.fiap.javaChallenge.domainmodel.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
