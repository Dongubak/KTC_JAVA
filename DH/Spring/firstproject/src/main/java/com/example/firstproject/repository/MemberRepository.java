package com.example.firstproject.repository;

import com.example.firstproject.entity.MemberArticle;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<MemberArticle, Long> {
    @Override
    ArrayList<MemberArticle> findAll();
}
