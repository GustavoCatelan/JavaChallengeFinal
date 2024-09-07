package br.com.fiap.javaChallenge.service.product;

import br.com.fiap.javaChallenge.domainmodel.product.Product;

import java.util.List;

public interface ProductService {

    Product save(Product p);

    void delete(Product p);

    void deleteById(long id);

    List<Product> findAllProduct();
}
