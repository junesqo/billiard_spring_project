package kg.junesqo.billiard.services;

import kg.junesqo.billiard.domain.Product;
import kg.junesqo.billiard.dto.ProductDTO;

import java.util.List;


public interface ProductService {

    Iterable<Product> findAll();

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    ProductDTO partialUpdateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);
}
