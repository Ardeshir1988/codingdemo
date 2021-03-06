package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.HouseType;
import com.ardeshir.codingdemo.service.IHouseService;
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

    private IHouseService houseService;

    @Autowired
    HouseRestController(IHouseService houseService)
    {
        this.houseService=houseService;
    }
    @ApiOperation(value = "View a list of Houses")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<House> getAllHouses()
    {
        return houseService.getAllHouses();
    }

    @ApiOperation(value = "Update House")
    @RequestMapping(value = "/updatehouse",method = RequestMethod.POST)
    public House updateHouses(
                              @RequestParam("id")int houseId,
                              @RequestParam("housetype")HouseType houseType,
                              @RequestParam("address")String houseAddress,
                              @RequestParam("room")int houseQuantityRooms)
    {
        return houseService.updateHouses(houseId,houseType,houseAddress,houseQuantityRooms);
    }

    @ApiOperation(value = "Add House")
    @RequestMapping(value = "/addhouse",method = RequestMethod.PUT)
    public House addHouses(@RequestParam("housetype")HouseType houseType,
                              @RequestParam("address")String houseAddress,
                              @RequestParam("room")int houseQuantityRooms,
                              @RequestParam("personid") int ownerId)
    {
        return houseService.addHouses(houseType,houseAddress,houseQuantityRooms,ownerId);
    }
}
