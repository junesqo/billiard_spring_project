package kg.junesqo.billiard.services;

import kg.junesqo.billiard.domain.Product;


public interface ProductService {

    Iterable<Product> findAll();

}
