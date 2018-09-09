package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.repository.HouseRepository;
import com.ardeshir.codingdemo.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseController {
    private IHouseService houseService;
    @Autowired
    HouseController(IHouseService houseService)
    {
        this.houseService=houseService;
    }
    @GetMapping("/houses")
    public String getAllHouses(Model model)
    {
        model.addAttribute("houses",houseService.getAllHouses());
        return "house-page";
    }
}
