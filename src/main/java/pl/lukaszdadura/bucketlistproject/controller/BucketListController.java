package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;
import pl.lukaszdadura.bucketlistproject.service.CategoryService;
import pl.lukaszdadura.bucketlistproject.service.UserAchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("user")
public class BucketListController {

    private final UserService userService;
    private final AchievementService achievementService;
    private final CategoryService categoryService;
    private final UserAchievementService userAchievementService;

    @Autowired
    public BucketListController(UserService userService, AchievementService achievementService, CategoryService categoryService, UserAchievementService userAchievementService) {
        this.userService = userService;
        this.achievementService = achievementService;
        this.categoryService = categoryService;
        this.userAchievementService = userAchievementService;
    }


    @GetMapping("/")
    public String home(Model model) {
        User user = userService.findAllUsers().get(0);
        model.addAttribute("user", user);
        System.out.println(user);
        List<Achievement> randomAchievementList = achievementService.findRandomThree();
        model.addAttribute("randomAchievementList", randomAchievementList);

        return "home3";
    }

//    @GetMapping("/achievements")
//    public String achievements(Model model) {
//        List<Achievement> achievement = achievementService.findAllAchievements();
//        Optional<Achievement> achievement1 = achievementService.findAchievementById(1L);
//        model.addAttribute("achievements", achievement);
//        model.addAttribute("achi", achievement1);
//        return "home";
//    }

}
