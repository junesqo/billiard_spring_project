package kg.junesqo.billiard.services;

import kg.junesqo.billiard.domain.Category;
import kg.junesqo.billiard.repositories.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> findAll() {
        return null;
    }
}
