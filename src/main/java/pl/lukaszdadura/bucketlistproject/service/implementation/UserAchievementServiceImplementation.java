package pl.lukaszdadura.bucketlistproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;
import pl.lukaszdadura.bucketlistproject.repository.UserAchievementRepository;
import pl.lukaszdadura.bucketlistproject.service.UserAchievementService;

import java.util.List;
import java.util.Optional;

@Service
public class UserAchievementServiceImplementation implements UserAchievementService {

    private final UserAchievementRepository userAchievementRepository;

    @Autowired
    public UserAchievementServiceImplementation(UserAchievementRepository userAchievementRepository) {
        this.userAchievementRepository = userAchievementRepository;
    }

    @Override
    public void addUserAchievement(UserAchievement userAchievement) {
        userAchievementRepository.save(userAchievement);
    }

    @Override
    public List<UserAchievement> findAllUserAchievements() {
        return userAchievementRepository.findAll();
    }

    @Override
    public Optional<UserAchievement> findUserAchievementById(Long id) {
        return userAchievementRepository.findById(id);
    }

    @Override
    public void deleteUserAchievement(Long id) {
        userAchievementRepository.deleteById(id);
    }

    @Override
    public void updateUserAchievement(UserAchievement userAchievement) {
        userAchievementRepository.save(userAchievement);
    }

    public List<UserAchievement> findUsersAchievements(Long id) { return userAchievementRepository.findAllByUserId(id);}
}
