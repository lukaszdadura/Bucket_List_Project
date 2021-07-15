package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukaszdadura.bucketlistproject.service.UserAchievementService;

@Controller
public class UserAchievementController {

    private final UserAchievementService userAchievementService;

    @Autowired
    public UserAchievementController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

//    @GetMapping("/user/achievements")
//    public String userAchievementList(Model model)
}
