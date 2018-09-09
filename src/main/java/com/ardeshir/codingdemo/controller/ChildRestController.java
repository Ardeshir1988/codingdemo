package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.service.IChildService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildRestController {

    private IChildService childService;
    @Autowired
    ChildRestController(IChildService childService)
    {
        this.childService=childService;
    }

    @ApiOperation(value = "View a list Of Children")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Child> getAllChild()
    {
        return childService.getAllChildren();
    }
    @ApiOperation(value = "Update Child By ChildId")
    @RequestMapping(value = "/updatechild",method = RequestMethod.GET)
    public Child updateAgeAndNameChildById( @RequestParam(value = "id") int childId,
                                            @RequestParam(value = "age") int newChildAge,
                                            @RequestParam(value = "name") String newChildName)
    {
        return childService.updateAgeAndNameChildById(childId,newChildAge,newChildName);
    }
    @ApiOperation(value = "Add Child")
    @RequestMapping(value = "/addchild",method = RequestMethod.GET)
    public Child addNewChild(@RequestParam("name") String childName,
                              @RequestParam("age") int childAge,
                              @RequestParam("gender") String childGender,
                              @RequestParam("schoolname") String childSchoolName,
                              @RequestParam("parentid") int parentId)
    {
        return childService.addNewChild(childName,childAge,childGender,childSchoolName,parentId);
    }
    @ApiOperation(value = "View a list Of Children By ParentId")
    @RequestMapping(value = "/getchildren",method = RequestMethod.GET)
    public List<Child> getChildrenByParent(@RequestParam("parentid") int parentId)
    {
        return childService.getChildrenByParentId(parentId);
    }
}
