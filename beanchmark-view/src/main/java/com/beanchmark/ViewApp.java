package com.beanchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class ViewApp {

    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("welcome","hello world!");
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(ViewApp.class,args);
    }
}
