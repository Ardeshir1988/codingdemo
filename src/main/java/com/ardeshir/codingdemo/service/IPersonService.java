package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAllPeople();
    Person updatePersonNameByPersonId(Integer id,String name);
    Person deleteHouseByPersonId(Integer id);
    Person deleteChildrenByParentId(int personId);
    Person addNewPerson( String name, int age, String gender);
    String updatePerson(Person editedPerson);
    Person getPersonByName(String personName);
}
