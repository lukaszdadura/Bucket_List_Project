package pl.lukaszdadura.bucketlistproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.repository.AchievementRepository;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;

import java.util.List;
import java.util.Optional;

public class AchievementServiceImplementation implements AchievementService {

    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementServiceImplementation(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    @Override
    public List<Achievement> findAllAchievements() {
        return achievementRepository.findAll();
    }

    @Override
    public Optional<Achievement> findAchievementById(Long id) {
        return achievementRepository.findById(id);
    }

    @Override
    public void deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
    }

    @Override
    public void updateAchievement(Achievement achievement) {
        achievementRepository.save(achievement);
    }
}
