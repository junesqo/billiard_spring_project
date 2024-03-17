package kg.junesqo.billiard.repositories;

import kg.junesqo.billiard.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
