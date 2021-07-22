package pl.lukaszdadura.bucketlistproject.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.repository.AchievementRepository;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;

import java.util.*;

@Service
public class AchievementServiceImplementation implements AchievementService {

    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementServiceImplementation(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Transactional
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

    public List<Achievement> findRandomThree() {
        List<Achievement> achievementList = achievementRepository.findAll();
        Collections.shuffle(achievementList);
        int randomAchievementListLength = 3;
        List<Achievement> randomAchievementList = achievementList.subList(0, randomAchievementListLength);
        return randomAchievementList;
    }
}
