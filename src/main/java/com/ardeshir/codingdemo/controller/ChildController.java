package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.repository.ChildRepository;
import com.ardeshir.codingdemo.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChildController {
    private ChildService childService;
    @Autowired
    ChildController(ChildService childService)
    {
        this.childService=childService;
    }
    @GetMapping("/children")
    public String getChildren(Model model)
    {
        model.addAttribute("children",childService.getAllChildren());
        return "child-page";
    }
}
