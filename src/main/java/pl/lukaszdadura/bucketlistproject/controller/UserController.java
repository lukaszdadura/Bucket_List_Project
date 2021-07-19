package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;
import pl.lukaszdadura.bucketlistproject.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/home")
    public String userHome(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedUser = ((User)principal);
        model.addAttribute("user", loggedUser);
        return "user/userHome";}

    @GetMapping("/achievementmanage")
    public String achievementManage() {
        return "user/achievementManage1";
    }

//    @GetMapping("/addachievements")
//    public String getAchievementAdd (Model model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User loggedUser = ((User)principal);
//        List<UserAchievement> userAchievementList = userAchievementService.findUsersAchievements(loggedUser.getId());
//        model.addAttribute("userAchievementList", userAchievementList);
//        return "/user/userAchievementList";
//    }

//    @PostMapping("/addachievements")
//    public String postAchievementAdd (Model model){}
}

