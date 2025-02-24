package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;

import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("signup")
    public String signup() {
        return "members/new";
    }

    @PostMapping("/join")
    public String signup(MemberForm form) {
        log.info(form.toString());
        Member member = form.toEntity();

        log.info(member.toString());

        Member saved = memberRepository.save(member);

        log.info(saved.toString());

        return "";
    }


}
