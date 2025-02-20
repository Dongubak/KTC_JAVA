package com.example.firstp.dto;

import com.example.firstp.entity.Member;

public class MemberForm {
    private Long id;
    private String email;
    private String password;

    public Member toEntity() {
        return new Member(this.id, this.email, this.password);
    }

    public MemberForm(final Long id, final String email, final String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return "MemberForm(id=" + this.id + ", email=" + this.email + ", password=" + this.password + ")";
    }
}
