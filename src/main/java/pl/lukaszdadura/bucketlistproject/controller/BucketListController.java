package pl.lukaszdadura.bucketlistproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BucketListController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
