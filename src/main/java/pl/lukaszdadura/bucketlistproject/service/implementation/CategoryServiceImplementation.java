package pl.lukaszdadura.bucketlistproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lukaszdadura.bucketlistproject.model.Category;
import pl.lukaszdadura.bucketlistproject.repository.CategoryRepository;
import pl.lukaszdadura.bucketlistproject.service.CategoryService;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
}
