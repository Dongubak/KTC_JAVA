package com.example.firstproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class SecondController {

    @GetMapping("/random-quote")
    public String niceToMeetYou(Model model){
        String[] quotes = {
                "행복은 습관이다." + "-하버드-",
                "고개 숙이지 마십시오." + "바라보십시오. -헬렌 켈러-",
                "고난의 시기에 동요하지" + "-베토벤-",
                "당신이 할 수 있다고 믿든" + "-헨리 포드-",
                "작은 기회로부터 " + "-데모스테네스-"
        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
