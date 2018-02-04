package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.CustomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Transactional
@Service
public class CustomRepositoryImp implements CustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void refresh(Person person) {
        entityManager.refresh(person);
    }
}
