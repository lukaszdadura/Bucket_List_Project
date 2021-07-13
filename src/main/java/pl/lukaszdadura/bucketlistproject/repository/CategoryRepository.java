package pl.lukaszdadura.bucketlistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszdadura.bucketlistproject.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

}
