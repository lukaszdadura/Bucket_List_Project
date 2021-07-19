package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserAchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserService;

import java.util.List;

@Controller
public class UserAchievementController {

    private final UserAchievementService userAchievementService;
    private final UserService userService;
    private final AchievementService achievementService;

    @Autowired
    public UserAchievementController(UserAchievementService userAchievementService, UserService userService, AchievementService achievementService) {
        this.userAchievementService = userAchievementService;
        this.userService = userService;
        this.achievementService = achievementService;
    }

    @GetMapping("/user/showachievements")
    public String showAllUserAchievements (Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedUser = ((User)principal);
        List<UserAchievement> userAchievementList = userAchievementService.findUsersAchievements(loggedUser.getId());
        model.addAttribute("userAchievementList", userAchievementList);
        return "/user/userAchievementList";
    }




//    @GetMapping("/user/achievements")
//    public String userAchievementList(Model model)
}
