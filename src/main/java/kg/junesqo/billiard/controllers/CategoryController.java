package kg.junesqo.billiard.controllers;

import kg.junesqo.billiard.services.CategoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categories")
    public String getCategories(Model model) {

        model.addAttribute("categories", categoryService.findAll());

        return "categories";

    }

}
