package com.toastmaster.demo.controller;

import com.toastmaster.demo.model.Member;
import com.toastmaster.demo.repository.MemberRepository;
import com.toastmaster.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> showMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberService.get(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.save(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.delete(id));
    }

    @PutMapping
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        memberService.update(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Member> getByEmail(@PathVariable String email) {
        Member member = memberService.getByEmail(email);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
