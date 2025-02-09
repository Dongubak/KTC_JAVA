package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "dongubak");
        return "greetings";
    }

    @GetMapping("bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "dongubak");
        return "goodbye";
    }

    @GetMapping("random-quote")
    public String randomQuote(Model model) {

        String[] quotes = {
            "행복은 습관이다. 그것을 몸에 지니라. " + "-허버드-",
            "고개 숙이지 마십시오. 세상을 똑바로 정면으로 " + "바라보십시오. -헬렌 켈러"
        };
        int randInt = (int)(Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);

        return "quote";
    }
}
