package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.HouseType;
import com.ardeshir.codingdemo.model.Person;
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
@RequestMapping("/api/house")
public class HouseRestController {

    private HouseRepository houseRepository;
    private PersonRepository personRepository;

    @Autowired
    HouseRestController(HouseRepository houseRepository, PersonRepository personRepository)
    {
        this.houseRepository=houseRepository;
        this.personRepository=personRepository;
    }
    @ApiOperation(value = "View a list of Houses")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<House> getAllHouses()
    {
        return houseRepository.findAll();
    }

    @ApiOperation(value = "Update House")
    @RequestMapping(value = "/updatehouse",method = RequestMethod.GET)
    public House updateHouses(
                              @RequestParam("id")int id,
                              @RequestParam("housetype")HouseType houseType,
                              @RequestParam("address")String address,
                              @RequestParam("room")int room)
    {
        House house=houseRepository.findOne(id);
        house.setHouseType(houseType);
        house.setHouseAddress(address);
        house.setHouseRoom(room);
        return houseRepository.saveAndFlush(house);
    }

    @ApiOperation(value = "Add House")
    @RequestMapping(value = "/addhouse",method = RequestMethod.GET)
    public House addHouses(@RequestParam("housetype")HouseType houseType,
                              @RequestParam("address")String address,
                              @RequestParam("room")int room,
                              @RequestParam("ownerid") int ownerId)
    {
        House house=new House();
        house.setHouseType(houseType);
        house.setHouseAddress(address);
        house.setHouseRoom(room);
        Person owner=personRepository.findOne(ownerId);
        house.setHouseOwner(owner);
        return houseRepository.saveAndFlush(house);
    }
}
