package pl.lukaszdadura.bucketlistproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;

import java.util.List;
import java.util.Optional;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {

    Optional<UserAchievement> findById(Long id);
    List<UserAchievement> findAllByUserId(Long id);
    @Query(value = "SELECT * FROM user_achievement ua WHERE ua.user_id = ?1",nativeQuery = true)
    List<UserAchievement> findAllUserAchievementById(Long id);

}
