package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.ChildRepository;
import com.ardeshir.codingdemo.repository.HouseRepository;
import com.ardeshir.codingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService implements IPersonService{

    @PersistenceContext
    private EntityManager entityManager;

    private PersonRepository personRepository;
    private HouseRepository houseRepository;
    private ChildRepository childRepository;

    @Autowired
    private void PersonServiceSetterInjection(PersonRepository personRepository,
                                              HouseRepository houseRepository,
                                              ChildRepository childRepository)
    {
        this.personRepository=personRepository;
        this.houseRepository=houseRepository;
        this.childRepository=childRepository;
    }
    @Override
    public List<Person> getAllPeople()
    {
        return personRepository.findAll();
    }
    @Override
    public Person updatePersonNameByPersonId(Integer id,String name)
    {
        personRepository.updatename(name,id);
        return personRepository.findOne(id);
    }
    @Override
    public Person deleteHouseByPersonId(Integer id)
    {
        Person person= personRepository.findOne(id);
        houseRepository.deleteByHouseOwner(person);
        entityManager.refresh(person);
        return personRepository.findOne(person.getPersonId());
    }
    @Override
    public Person deleteChildrenByParentId(int personId)
    {
        Person person=new Person();
        person.setPersonId(personId);
        childRepository.deleteAllByChildParent(person);
        return personRepository.findOne(personId);
    }
    @Override
    public Person addNewPerson( String name, int age, String gender)
    {
        Person newPerson=new Person();
        newPerson.setPersonName(name);
        newPerson.setPersonAge(age);
        newPerson.setPersonGender(gender);
        return personRepository.saveAndFlush(newPerson);
    }
    @Override
    public String updatePerson(Person editedPerson)
    {
        Person person=personRepository.findOne(editedPerson.getPersonId());
        person.setPersonGender(editedPerson.getPersonGender());
        person.setPersonName(editedPerson.getPersonName());
        person.setPersonAge(editedPerson.getPersonAge());
        return "edited";
    }
    @Override
    public Person getPersonByName(String personName)
    {
        return personRepository.findByPersonName(personName);
    }
}
