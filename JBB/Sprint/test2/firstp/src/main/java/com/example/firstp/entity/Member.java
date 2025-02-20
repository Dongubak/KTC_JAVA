package com.example.firstp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String email;
    @Column
    String password;

    public Member(final Long id, final String email, final String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Member() {
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Member(id=" + var10000 + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
