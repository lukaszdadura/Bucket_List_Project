package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukaszdadura.bucketlistproject.model.Category;
import pl.lukaszdadura.bucketlistproject.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String categoryList(Model model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "categoryList";
    }

    @GetMapping("/categoryadd")
    public String getCategoryAdd(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/categoryAdd";
    }

    @PostMapping("/categoryadd")
    public String postCategoryAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
}
