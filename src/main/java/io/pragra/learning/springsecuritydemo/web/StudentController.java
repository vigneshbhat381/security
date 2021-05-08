package io.pragra.learning.springsecuritydemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
}
