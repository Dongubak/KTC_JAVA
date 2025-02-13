package com.example.firstproject.dto;

import com.example.firstproject.entity.MemberArticle;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {

    private String email;
    private String password;

    public MemberArticle toEntity() {
        return new MemberArticle(null, email, password);
    }
}
