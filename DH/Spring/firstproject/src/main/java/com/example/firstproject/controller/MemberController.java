package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.MemberArticle;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/signup")
    public String newArticleForm() {
        return "members/signup";
    }

    @PostMapping("/members/join")
    public String createArticle(MemberArticle form) {

        log.info(form.toString());
        //System.out.println(form.toString());

        MemberArticle memberArticle = form.toEntity();
        log.info(memberArticle.toString());
        //System.out.println(memberArticle.toString());

        MemberArticle saved = memberRepository.save(memberArticle);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "redirect:/members/" + saved.getId();

    }
    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        //데이터 가져오고
        MemberArticle memberEntity = memberRepository.findById(id).orElse(null);
        //Optional<MemberArticle> MemberEntity = MemberRepository.findById(id);
        //데이터 등록하고
        model.addAttribute("memberArticle", memberEntity);
        //뷰 페이지 반환하고
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        //모든데이터 가져오고
        ArrayList<MemberArticle> memberEntityList = memberRepository.findAll();
        //데이터 등록하고
        model.addAttribute("memberList", memberEntityList);
        //설정하고
        return "members/index";
    }


    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //데이터 가져오고
        MemberArticle memberEntity = memberRepository.findById(id).orElse(null);
        //데이터 등록하고
        model.addAttribute("memberArticle", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form, Model model){
        log.info(form.toString());

        MemberArticle memberEntity = form.toEntity();
        log.info(memberEntity.toString());

        MemberArticle target = memberRepository.findById(memberEntity.getId()).orElse(null);

        if(target != null){
            memberRepository.save(memberEntity);
        }
        //뷰 페이지 반환하고
        return "redirect:/members/" + memberEntity.getId();
    }
}
