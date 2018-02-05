package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.HouseType;
import com.ardeshir.codingdemo.service.HouseService;
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

    private HouseService houseService;

    @Autowired
    HouseRestController(HouseService houseService)
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
    @RequestMapping(value = "/updatehouse",method = RequestMethod.GET)
    public House updateHouses(
                              @RequestParam("id")int houseId,
                              @RequestParam("housetype")HouseType houseType,
                              @RequestParam("address")String houseAddress,
                              @RequestParam("room")int houseQuantityrooms)
    {
        return houseService.updateHouses(houseId,houseType,houseAddress,houseQuantityrooms);
    }

    @ApiOperation(value = "Add House")
    @RequestMapping(value = "/addhouse",method = RequestMethod.GET)
    public House addHouses(@RequestParam("housetype")HouseType houseType,
                              @RequestParam("address")String houseAddress,
                              @RequestParam("room")int houseQuantityrooms,
                              @RequestParam("ownerid") int ownerId)
    {
        return houseService.addHouses(houseType,houseAddress,houseQuantityrooms,ownerId);
    }
}
