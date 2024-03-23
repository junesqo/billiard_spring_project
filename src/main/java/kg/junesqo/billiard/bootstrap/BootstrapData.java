package kg.junesqo.billiard.bootstrap;

import kg.junesqo.billiard.domain.Category;
import kg.junesqo.billiard.domain.Product;
import kg.junesqo.billiard.domain.Publisher;
import kg.junesqo.billiard.repositories.CategoryRepository;
import kg.junesqo.billiard.repositories.ProductRepository;
import kg.junesqo.billiard.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(CategoryRepository categoryRepository, ProductRepository productRepository, PublisherRepository publisherRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category tables = new Category();
        tables.setTitle("Бильярдные столы");

        Product classic = new Product();
        classic.setName("Бильярдный стол Классик");
        classic.setPrice(10000);
        classic.setDescription("Описание");

        Category categorySaved = categoryRepository.save(tables);
        Product productSaved = productRepository.save(classic);

        categorySaved.getProducts().add(productSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Admin");
        publisher.setNumber("0700123456");
        Publisher savedPublisher = publisherRepository.save(publisher);

        classic.setPublisher(savedPublisher);
        

        categoryRepository.save(categorySaved);

        System.out.println("Category count: " + categoryRepository.count());
        System.out.println("Product count: " + productRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
