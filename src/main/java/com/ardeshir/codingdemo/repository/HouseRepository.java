package com.ardeshir.codingdemo.repository;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Integer>{

    @Modifying(clearAutomatically = true)
    void deleteByHouseOwner(Person person);
    House findByHouseOwner(Person person);

}
