package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.ChildRepository;
import com.ardeshir.codingdemo.repository.PersonRepository;
import com.ardeshir.codingdemo.service.ChildService;
import com.ardeshir.codingdemo.service.HouseService;
import com.ardeshir.codingdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private PersonService personService;
    private ChildService childService;
    private HouseService houseService;
    @Autowired
    PersonController(PersonService personService, ChildService childService, HouseService houseService)
    {
        this.personService=personService;
        this.childService=childService;
        this.houseService=houseService;
    }
    @GetMapping("/people")
    public String getAllPeople(Model model)
    {
//        House house=new House();
//        model.addAttribute("house",house);
        model.addAttribute("people",personService.getAllPeople());
        return "person-page";
    }
    @GetMapping("/findperson")
    public String findPersonByName(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("people",personService.getPersonByName(name));
        return "person-page :: personfrg";
    }
    @RequestMapping(value = "/addperson",method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, Model model)
    {
        personService.addNewPerson(person.getPersonName(),person.getPersonAge(),person.getPersonGender());
        model.addAttribute("people",personService.getAllPeople());
        return "person-page :: personfrg";
    }
    @RequestMapping(value = "/editperson",method = RequestMethod.POST)
    public String editPerson(@ModelAttribute("person") Person person)
    {
        personService.updatePerson(person);
        return "redirect:/people";
    }
    @RequestMapping(value = "/findchildrenbyparentid",method = RequestMethod.GET)
    public String findChildByPersonId(@RequestParam("personid") int parentId, Model model)
    {
        model.addAttribute("children",childService.getChildrenByParentId(parentId));
        return "person-page :: personchildrenfrg";
    }
    @RequestMapping(value = "/findhousebypersonid",method = RequestMethod.GET)
    public String findHouseByPersonId(@RequestParam("personid") int personId, Model model)
    {
        model.addAttribute("house",houseService.findHouseByPersonId(personId));
        return "person-page :: personhousefrg";
    }

}
