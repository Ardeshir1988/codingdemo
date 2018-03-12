package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseController {
    private HouseRepository houseRepository;
    @Autowired
    HouseController(HouseRepository houseRepository)
    {
        this.houseRepository=houseRepository;
    }
    @GetMapping("/houses")
    public String getAllHouses(Model model)
    {
        model.addAttribute("houses",houseRepository.findAll());
        return "house-page";
    }
}
