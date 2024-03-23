package kg.junesqo.billiard.services;

import kg.junesqo.billiard.domain.Product;
import kg.junesqo.billiard.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
