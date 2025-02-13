package com.example.firstp.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("role", "master");
        return "greeting";
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("role", "apprentice");
        return "goodbye";
    }
}
