package com.ardeshir.codingdemo.repository;

import com.ardeshir.codingdemo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class HouseRepositoryTest {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    PersonRepository personRepository;
    @Test
    public void deleteHouse()
    {
        Person person=personRepository.findByPersonName("Mariel");
        assertNotNull(houseRepository.findByHouseOwnerId(person.getPersonId()));
        houseRepository.deleteByHouseOwner(person);
        assertNull(houseRepository.findByHouseOwnerId(person.getPersonId()));
    }
}
