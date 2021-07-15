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
    public String getCategoryAdd() {
        return "categoryAdd";
    }

    @RequestMapping(value = "/categoryadd", method = RequestMethod.POST)
    public String postCategoryAdd(@RequestParam String points, @RequestParam String type) {
        Category category = new Category();
        category.setPoints(Integer.parseInt(points));
        category.setType(type);
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
}
