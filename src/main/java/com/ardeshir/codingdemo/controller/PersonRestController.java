package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.Person;

import com.ardeshir.codingdemo.service.PersonService;
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

    private PersonService personService;
    @Autowired
    PersonRestController(PersonService personService)
    {
        this.personService=personService;
    }

    @ApiOperation(value = "View a list of People")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }
    @ApiOperation(value = "Update Person Name By PersonId")
    @RequestMapping(value = "/updatename",method = RequestMethod.GET)
    public Person updatePersonNameByPersonId(@RequestParam("id")Integer personId,@RequestParam("name")String personName)
    {
        return personService.updatePersonNameByPersonId(personId,personName);
    }
    @ApiOperation(value = "Delete Person's House By PersonId")
    @RequestMapping(value = "/deletehouse",method = RequestMethod.GET)
    public Person deleteHouseByPersonId(@RequestParam("id")Integer personId)
    {
        return personService.deleteHouseByPersonId(personId);
    }
    @ApiOperation(value = "Delete Children By ParentId")
    @RequestMapping(value = "/deletechildren",method = RequestMethod.GET)
    public Person deleteChildrenByParentId(@RequestParam("id") int parentId)
    {
        return personService.deleteChildrenByParentId(parentId);
    }
    @ApiOperation(value = "Add Person")
    @RequestMapping(value = "/addperson",method = RequestMethod.GET)
    public Person addNewPerson(@RequestParam("name") String personName,
                               @RequestParam("age") int personAge,
                               @RequestParam("gender") String personGender)
    {
        return personService.addNewPerson(personName,personAge,personGender);
    }
}
