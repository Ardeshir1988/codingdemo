package com.ardeshir.codingdemo.repository;


import com.ardeshir.codingdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Person p set p.personName=:name where p.personId=:pid")
    void updatename(@Param("name") String name,@Param("pid") Integer id);
}
