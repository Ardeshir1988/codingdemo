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

    @Modifying(clearAutomatically = true)
    @Query("update Person p set p.personName=:name where p.personId=:pid")
    void updatename(@Param("name") String name,@Param("pid") Integer id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Person p set p.personName=:name,p.personGender=:gender,p.personAge=:age  where p.personId=:pid")
    void updatePerson(@Param("name") String name,@Param("gender") String gender,@Param("age") int age,@Param("pid") Integer id);

    Person findByPersonName(String name);
}
