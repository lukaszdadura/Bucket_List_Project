package pl.lukaszdadura.bucketlistproject.service;

import pl.lukaszdadura.bucketlistproject.model.UserAchievement;

import java.util.List;
import java.util.Optional;

public interface UserAchievementService {

    void addUserAchievement(UserAchievement userAchievement);
    List<UserAchievement> findAllUserAchievements();
    Optional<UserAchievement> findUserAchievementById(Long id);
    void deleteUserAchievement(Long id);
    void updateUserAchievement(UserAchievement userAchievement);
}
