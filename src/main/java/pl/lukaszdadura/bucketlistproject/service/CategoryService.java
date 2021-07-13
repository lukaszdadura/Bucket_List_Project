package pl.lukaszdadura.bucketlistproject.service;

import pl.lukaszdadura.bucketlistproject.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void addCategory(Category category);
    List<Category> findAllCategories();
    Optional<Category> findCategoryById(Long id);
    void deleteCategory(Long id);
    void updateCategory(Category category);



}
