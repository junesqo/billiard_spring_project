package kg.junesqo.billiard.services;

import kg.junesqo.billiard.domain.Product;
import kg.junesqo.billiard.dto.ProductDTO;
import kg.junesqo.billiard.mapper.ProductMapper;
import kg.junesqo.billiard.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productMapper::productToProductDTO).orElse(null);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(productDTO.getName());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());
            // Set other properties as needed

            Product updatedProduct = productRepository.save(existingProduct);
            return productMapper.productToProductDTO(updatedProduct);
        }
        return null; // or throw an exception if needed
    }

    @Override
    public ProductDTO partialUpdateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            if (productDTO.getName() != null) {
                existingProduct.setName(productDTO.getName());
            }
            if (productDTO.getPrice() != null) {
                existingProduct.setPrice(productDTO.getPrice());
            }
            if (productDTO.getDescription() != null) {
                existingProduct.setDescription(productDTO.getDescription());
            }
            // Update other properties as needed

            Product updatedProduct = productRepository.save(existingProduct);
            return productMapper.productToProductDTO(updatedProduct);
        }
        return null; // or throw an exception if needed
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
