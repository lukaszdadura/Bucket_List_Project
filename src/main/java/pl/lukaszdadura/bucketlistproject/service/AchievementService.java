package pl.lukaszdadura.bucketlistproject.service;

import pl.lukaszdadura.bucketlistproject.model.Achievement;

import java.util.List;
import java.util.Optional;

public interface AchievementService {

    void addAchievement(Achievement achievement);
    List<Achievement> findAllAchievements();
    Optional<Achievement> findAchievementById(Long id);
    void deleteAchievement(Long id);
    void updateAchievement(Achievement achievement);
}
