package com.toastmaster.demo.service.implementation;

import com.toastmaster.demo.model.Member;
import com.toastmaster.demo.repository.MemberRepository;
import com.toastmaster.demo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @PostConstruct
    private void setTypeClass() {
        memberRepository.setClazz(Member.class);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        Long id = member.getId();
        Member newMember = new Member();
        newMember.setId(id);
        newMember.setCountry(member.getCountry());
        newMember.setEmail(member.getEmail());
        newMember.setFirstName(member.getFirstName());
        newMember.setLastName(member.getLastName());
        return memberRepository.save(newMember);
    }

    @Override
    public Member get(Long id) {
        return memberRepository.get(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Member delete(Long id) {
        return memberRepository.delete(id);
    }

    @Override
    public Member getByEmail(String email) {
        return memberRepository.getByEmail(email).orElseThrow(NoSuchElementException::new);
    }
}
