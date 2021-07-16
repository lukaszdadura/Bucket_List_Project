package pl.lukaszdadura.bucketlistproject.service;

import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AchievementService {

    void addAchievement(Achievement achievement);
    List<Achievement> findAllAchievements();
    Optional<Achievement> findAchievementById(Long id);
    void deleteAchievement(Long id);
    void updateAchievement(Achievement achievement);
    public List<Achievement> findRandomThree();
}
