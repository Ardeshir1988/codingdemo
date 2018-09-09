package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.model.Person;

import java.util.List;

public interface IChildService {
    List<Child> getAllChildren();
    Child updateAgeAndNameChildById(  int childId, int newChildAge, String newChildName);
    Child addNewChild( String name, int age, String gender, String schoolname, int parentid);
    List<Child> getChildrenByParentId(int parentId);
}
