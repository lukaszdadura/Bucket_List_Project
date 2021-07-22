package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.Category;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;
import pl.lukaszdadura.bucketlistproject.service.CategoryService;

import java.util.List;

@Controller
public class AchievementController {

    private final AchievementService achievementService;
    private final CategoryService categoryService;

    @Autowired
    public AchievementController(AchievementService achievementService, CategoryService categoryService) {
        this.achievementService = achievementService;
        this.categoryService = categoryService;
    }

    @GetMapping("/achievements")
    public String achievementList(Model model) {
        List<Achievement> achievementList = achievementService.findAllAchievements();
        model.addAttribute("achievementList", achievementList);
        return "achievementList";
    }

    @GetMapping("/achievementadd")
    public String getAchievementAdd(Model model) {
        Achievement achievement = new Achievement();
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("achievement", achievement);
        model.addAttribute("categorylist", categoryList);
        return "admin/achievementAdd";
    }

    @PostMapping("/achievementadd")
    public String postAchievementAdd(@ModelAttribute("achievement") Achievement achievement) {
        achievementService.addAchievement(achievement);
        return "redirect:/achievements";
    }
}
