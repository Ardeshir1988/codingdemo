package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.ChildRepository;
import com.ardeshir.codingdemo.repository.PersonRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildRestController {

    private ChildRepository childRepository;
    private PersonRepository personRepository;

    @Autowired
    ChildRestController(ChildRepository childRepository,PersonRepository personRepository)
    {
        this.personRepository=personRepository;
        this.childRepository=childRepository;
    }
    @ApiOperation(value = "View a list Of Children")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Child> getAllChild()
    {
        return childRepository.findAll();
    }
    @ApiOperation(value = "Update Child By ChildId")
    @RequestMapping(value = "/updatechild",method = RequestMethod.GET)
    public Child updateAgeAndNameChildById( @RequestParam(value = "id") int childId,
                                            @RequestParam(value = "age") int newChildAge,
                                            @RequestParam(value = "name") String newChildName)
    {
        Child child=childRepository.findOne(childId);
        child.setChildAge(newChildAge);
        child.setChildName(newChildName);
        return childRepository.saveAndFlush(child);
    }
    @ApiOperation(value = "Add Child")
    @RequestMapping(value = "/addchild",method = RequestMethod.GET)
    public Child addNewPerson(@RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("gender") String gender,
                              @RequestParam("schoolname") String schoolname,
                              @RequestParam("parentid") int parentid)
    {
        Child newChild=new Child();
        newChild.setChildName(name);
        newChild.setChildAge(age);
        newChild.setChildGender(gender);
        newChild.setChildSchoolName(schoolname);
        Person parent=personRepository.findOne(parentid);
        newChild.setChildParent(parent);
        return childRepository.saveAndFlush(newChild);
    }
}
