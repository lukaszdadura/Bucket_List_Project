package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;

import java.util.List;

@Controller
public class AchievementController {

    private final AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/achievements")
    public String achievementList(Model model) {
        List<Achievement> achievementList = achievementService.findAllAchievements();
        model.addAttribute("achievementList", achievementList);
        return "achievementList";
    }
}
