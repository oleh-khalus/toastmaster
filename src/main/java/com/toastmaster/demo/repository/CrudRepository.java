package com.toastmaster.demo.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E> {

    List<E> findAll();

    E save (E e);

    Optional<E> get(Long id);

    E delete(Long id);

    void setClazz(Class<E> clazz);

}
