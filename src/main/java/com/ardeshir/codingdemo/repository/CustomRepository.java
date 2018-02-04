package com.ardeshir.codingdemo.repository;


import com.ardeshir.codingdemo.model.Person;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CustomRepository {
    @Transactional
    void refresh(Person person);
}
