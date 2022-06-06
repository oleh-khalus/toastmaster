package com.toastmaster.demo.repository;

import com.toastmaster.demo.model.Member;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member>{
    Optional<Member> getByEmail(String email);
}
