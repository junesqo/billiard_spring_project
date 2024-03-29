package kg.junesqo.billiard.controllers;

import kg.junesqo.billiard.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {

        model.addAttribute("products", productService.findAll());

        return "products";

    }

}
