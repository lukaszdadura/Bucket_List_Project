package pl.lukaszdadura.bucketlistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;

import java.util.Optional;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {

    Optional<UserAchievement> findById(Long id);

}
