package com.ardeshir.codingdemo.repository;

import com.ardeshir.codingdemo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;
    @Test
    public void addPersonAndupdateNameTest()
    {
        Person Ardeshir=new Person();
        Ardeshir.setPersonName("ardeshir");
        Ardeshir.setPersonAge(30);
        Ardeshir.setPersonGender("male");
        personRepository.save(Ardeshir);
        Person person=personRepository.findByPersonName("ardeshir");
        assertThat(person.getPersonAge(),is(equalTo(30)));
        personRepository.updatename("developer",person.getPersonId());
        assertNotNull(personRepository.findOne(person.getPersonId()).getPersonName(),is(equalTo("developer")));
    }
}
