package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.ChildRepository;
import com.ardeshir.codingdemo.repository.CustomRepository;
import com.ardeshir.codingdemo.repository.HouseRepository;
import com.ardeshir.codingdemo.repository.PersonRepository;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/person")
public class PersonRestController {

    private PersonRepository personRepository;
    private HouseRepository houseRepository;
    private CustomRepository customRepository;
    private ChildRepository childRepository;

    @Autowired
    PersonRestController(PersonRepository personRepository,HouseRepository houseRepository,CustomRepository customRepository,ChildRepository childRepository)
    {
        this.personRepository=personRepository;
        this.houseRepository=houseRepository;
        this.customRepository = customRepository;
        this.childRepository=childRepository;
    }

    @ApiOperation(value = "View a list of People")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }
    @ApiOperation(value = "Update Person Name By PersonId")
    @RequestMapping(value = "/updatename",method = RequestMethod.GET)
    public Person updatePersonNameByPersonId(@RequestParam("id")Integer id,@RequestParam("name")String name)
    {
        personRepository.updatename(name,id);
        return personRepository.findOne(id);
    }
    @ApiOperation(value = "Delete Person's House By PersonId")
    @RequestMapping(value = "/deletehouse",method = RequestMethod.GET)
    public Person deleteHouseByPersonId(@RequestParam("id")Integer id)
    {
        Person person= personRepository.findOne(id);
        houseRepository.deleteByHouseOwner(person);
        customRepository.refresh(person);
        return personRepository.findOne(person.getPersonId());
    }
    @ApiOperation(value = "Delete Children By ParentId")
    @RequestMapping(value = "/deletechildren",method = RequestMethod.GET)
    public Person deleteChildrenByParentId(@RequestParam("id") int personId)
    {
        Person person=new Person();
        person.setPersonId(personId);
        childRepository.deleteAllByChildParent(person);
        return personRepository.findOne(personId);
    }
    @ApiOperation(value = "Add Person")
    @RequestMapping(value = "/addperson",method = RequestMethod.GET)
    public Person addNewPerson(@RequestParam("name") String name,
                               @RequestParam("age") int age,
                               @RequestParam("gender") String gender)
    {
        Person newPerson=new Person();
        newPerson.setPersonName(name);
        newPerson.setPersonAge(age);
        newPerson.setPersonGender(gender);
        return personRepository.saveAndFlush(newPerson);
    }
}
