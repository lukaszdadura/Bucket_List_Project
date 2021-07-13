package pl.lukaszdadura.bucketlistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszdadura.bucketlistproject.model.Achievement;

import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    Optional<Achievement> findById(Long id);

}

