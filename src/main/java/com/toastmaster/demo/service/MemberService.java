package com.toastmaster.demo.service;

import com.toastmaster.demo.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member save (Member member);

    Member update(Member member);

    Member get(Long id);

    Member delete(Long id);

    Member getByEmail(String email);

}
