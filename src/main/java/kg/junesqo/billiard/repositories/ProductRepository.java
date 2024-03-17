package kg.junesqo.billiard.repositories;

import kg.junesqo.billiard.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
