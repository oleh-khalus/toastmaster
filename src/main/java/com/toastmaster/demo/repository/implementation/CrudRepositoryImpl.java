package com.toastmaster.demo.repository.implementation;

import com.toastmaster.demo.repository.CrudRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CrudRepositoryImpl<E> implements CrudRepository<E> {

    protected SessionFactory sessionFactory;
    private Class<E> clazz;

    @Autowired
    public CrudRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void setClazz(Class<E> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public List<E> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<E> query = session.createQuery("FROM " + clazz.getName(), clazz);
        return query.getResultList();
    }

    @Override
    public E save(E e) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(e);
        return e;
    }

    @Override
    public Optional<E> get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(clazz, id));
    }

    @Override
    public E delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        E entity = session.get(clazz, id);
        if (entity != null) {
            session.delete(entity);
        }
        return entity;
    }
}
