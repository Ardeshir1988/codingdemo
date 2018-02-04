package com.ardeshir.codingdemo.repository;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child,Integer> {

    @Transactional
    List<Child> getChildrenByChildParent(Person person);

    @Transactional
    void deleteAllByChildParent(Person person);

}
