package br.com.fiap.javaChallenge.service.product;

import br.com.fiap.javaChallenge.datasource.product.ProductRepository;
import br.com.fiap.javaChallenge.domainmodel.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Product save(Product p) {return this.repo.save(p);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Product p) {this.repo.delete(p);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id) {this.repo.deleteById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Product> findById(final long id) {return this.repo.findById(id);}

    @Transactional(propagation = Propagation.NEVER)
    public List<Product> findAllProduct() {return this.repo.findAll();}
}
