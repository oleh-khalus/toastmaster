package com.toastmaster.demo.repository.implementation;

import com.toastmaster.demo.model.Member;
import com.toastmaster.demo.repository.MemberRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepositoryImpl extends CrudRepositoryImpl<Member> implements MemberRepository {

    @Autowired
    public MemberRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Member> getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Member member = session.createQuery("from Member where email = :email", Member.class)
                .setParameter("email", email)
                .uniqueResult();
        return Optional.ofNullable(member);
    }
}
