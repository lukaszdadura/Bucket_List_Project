package pl.lukaszdadura.bucketlistproject.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.lukaszdadura.bucketlistproject.model.Achievement;
import pl.lukaszdadura.bucketlistproject.model.Category;
import pl.lukaszdadura.bucketlistproject.model.User;
import pl.lukaszdadura.bucketlistproject.model.UserAchievement;
import pl.lukaszdadura.bucketlistproject.repository.UserAchievementRepository;
import pl.lukaszdadura.bucketlistproject.repository.UserRepository;
import pl.lukaszdadura.bucketlistproject.service.AchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserAchievementService;
import pl.lukaszdadura.bucketlistproject.service.UserService;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class UserAchievementController {

    private final UserAchievementService userAchievementService;
    private final UserService userService;
    private final AchievementService achievementService;
    private final UserRepository userRepository;
    private final UserAchievementRepository userAchievementRepository;

    @Autowired
    public UserAchievementController(UserAchievementService userAchievementService, UserService userService, AchievementService achievementService, UserRepository userRepository, UserAchievementRepository userAchievementRepository) {
        this.userAchievementService = userAchievementService;
        this.userService = userService;
        this.achievementService = achievementService;
        this.userRepository = userRepository;
        this.userAchievementRepository = userAchievementRepository;
    }

    @GetMapping("/user/showachievements")
    public String showAllUserAchievements (Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedUser = ((User)principal);
        List<UserAchievement> userAchievementList = userAchievementService.findUsersAchievements(loggedUser.getId());
        model.addAttribute("userAchievementList", userAchievementList);
        return "/user/userAchievementList";
    }

    @GetMapping("/user/addachievements")
    public String getUserAchievementAdd(Model model) {
        UserAchievement userAchievement = new UserAchievement();
        List<Achievement> achievementList = achievementService.findAllAchievements();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(principal.toString());
        model.addAttribute("user", user);
        model.addAttribute("achievementlist", achievementList);
        model.addAttribute("userachievement", userAchievement);
        return "user/userAchievementAdd";
    }

    @PostMapping("/user/addachievements")
    public String postUserAchievementAdd(@ModelAttribute("userachievement") UserAchievement userAchievement) {
        userAchievementService.addUserAchievement(userAchievement);
        return "redirect:/user/achievementmanage";
    }


    @GetMapping("/user/editachievements")
    public String getUserAchievement(Model model) {
        UserAchievement userAchievement = new UserAchievement();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(principal.toString());
        List<UserAchievement> userAchievementList = userAchievementRepository.findAllByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("userachievement", userAchievement);
        model.addAttribute("userachievementlist", userAchievementList);
        return "/user/userAchievementEdit";
    }

    @PostMapping("/user/editachievements")
    public String postUserAchievementProcess(@ModelAttribute("userachievement") UserAchievement userAchievement, Model model) {
        UserAchievement userAchievement1 = new UserAchievement();
        Optional<UserAchievement> currentAchievement = userAchievementRepository.findById(userAchievement.getId());
        model.addAttribute("userachievement",currentAchievement);
        model.addAttribute("userachievementedit", userAchievement1);
        System.out.println(currentAchievement);
        return "/user/userAchievementEdit2";
    }

    @PostMapping("/user/editachievementsprocess")
    public String postUserAchievementProcess2(@ModelAttribute("userachievementedit") UserAchievement userAchievement1) {
        userAchievementService.updateUserAchievement(userAchievement1);
        return "redirect:/user/achievementmanage";
    }

    @GetMapping("/user/confirmachievements")
    public String getConfirmUserAchievement(Model model) {
        UserAchievement userAchievement = new UserAchievement();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(principal.toString());
        List<UserAchievement> userAchievementList = userAchievementRepository.findAllByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("userachievement", userAchievement);
        model.addAttribute("userachievementlist", userAchievementList);
        return "/user/userAchievementConfirm";
    }

    @PostMapping("/user/confirmachievements")
    public String postConfirmUserAchievementProcess(@ModelAttribute("userachievement") UserAchievement userAchievement, Model model) {
        UserAchievement userAchievement1 = new UserAchievement();
        Optional<UserAchievement> currentAchievement = userAchievementRepository.findById(userAchievement.getId());
        model.addAttribute("userachievement",currentAchievement);
        model.addAttribute("userachievementedit", userAchievement1);
        System.out.println(currentAchievement);
        return "/user/userAchievementConfirm2";
    }

    @PostMapping(value = "/user/confirmachievementsprocess")
    public String postConfirmUserAchievementProcess2(@RequestParam("evidence") MultipartFile file, @RequestParam("userachievementid") Long id) throws IOException, SQLException {
        Optional<UserAchievement> userAchievement = userAchievementService.findUserAchievementById(id);
        UserAchievement userAchievement1 = userAchievement.get();
        byte[] bytes = file.getBytes();
//        Blob blob = new SerialBlob(bytes);
        userAchievement1.setEvidence(bytes);
//        UserAchievement userAchievement1 = (UserAchievement) userAchievement;
//        byte[] evidenceBytes = multipartFile.getBytes();
//        userAchievement1.setEvidence(evidenceBytes);
        System.out.println(userAchievement1);
        userAchievementService.updateUserAchievement(userAchievement1);
        System.out.println(userAchievement);
        return "redirect:/user/achievementmanage";
    }

    @GetMapping("/user/userranking")
    public String getUserAchievementRanking(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(principal.toString());
        List<UserAchievement> userAchievementList = userAchievementRepository.findAllByUserId(user.getId());
        int counter = 0;
        for (UserAchievement userAchievement:
             userAchievementList) {
            List<Category> categoryList = userAchievement.getAchievement().getCategoryList();
            for (Category category :
                    categoryList) {
                counter += category.getPoints();
            }
        }
        model.addAttribute("counter", counter);
        return "/user/userRanking";
    }

}
