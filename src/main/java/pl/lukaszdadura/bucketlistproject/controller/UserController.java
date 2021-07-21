package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.repository.UserRepository;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserAchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AchievementService achievementService;
    private final UserAchievementService userAchievementService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, AchievementService achievementService, UserAchievementService userAchievementService, UserRepository userRepository) {
        this.userService = userService;
        this.achievementService = achievementService;
        this.userAchievementService = userAchievementService;
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String userHome(Model model) {
        List<Achievement> randomAchievementList = achievementService.findRandomThree();
        model.addAttribute("randomAchievementList", randomAchievementList);
        return "user/userHome";
    }

    @GetMapping("/achievementmanage")
    public String achievementManage() {
        return "user/achievementManage";
    }

}

