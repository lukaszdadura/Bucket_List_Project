package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.Category;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;
import pl.lukaszdadura.bucketlistproject.repository.UserAchievementRepository;
import pl.lukaszdadura.bucketlistproject.repository.UserRepository;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;
import pl.lukaszdadura.bucketlistproject.service.CategoryService;
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
    private final CategoryService categoryService;
    private final UserAchievementRepository userAchievementRepository;

    @Autowired
    public UserController(UserService userService, AchievementService achievementService, UserAchievementService userAchievementService, UserRepository userRepository, CategoryService categoryService, UserAchievementRepository userAchievementRepository) {
        this.userService = userService;
        this.achievementService = achievementService;
        this.userAchievementService = userAchievementService;
        this.userRepository = userRepository;
        this.categoryService = categoryService;
        this.userAchievementRepository = userAchievementRepository;
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

    @GetMapping("/login")
    public String login() {
        return "user/userLogin";
    }


    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "user/userSignup";
    }

    @GetMapping("/categories")
    public String categoryList(Model model) {
        List<Category> categoryList = categoryService.findAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "user/userCategoryList";
    }

    @GetMapping("/achievements")
    public String achievementList(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(principal.toString());
        List<UserAchievement> userAchievementList = userAchievementRepository.findAllByUserId(user.getId());
        model.addAttribute("userachievementlist", userAchievementList);
        return "user/userAchievementList";
    }

}

