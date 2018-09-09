package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.ChildRepository;
import com.ardeshir.codingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ChildService implements IChildService {

    private PersonRepository personRepository;
    private ChildRepository childRepository;

    @Autowired
    private void ChildServiceSetterInjection(PersonRepository personRepository, ChildRepository childRepository)
    {
        this.personRepository=personRepository;
        this.childRepository=childRepository;
    }
    @Override
    public List<Child> getAllChildren()
    {
        return childRepository.findAll();
    }
    @Override
    public Child updateAgeAndNameChildById(  int childId, int newChildAge, String newChildName)
    {
        Child child=childRepository.findOne(childId);
        child.setChildAge(newChildAge);
        child.setChildName(newChildName);
        return childRepository.saveAndFlush(child);
    }
    @Override
    public Child addNewChild( String name, int age, String gender, String schoolname, int parentid)
    {
        Child newChild=new Child();
        newChild.setChildName(name);
        newChild.setChildAge(age);
        newChild.setChildGender(gender);
        newChild.setChildSchoolName(schoolname);
        Person parent=personRepository.findOne(parentid);
        newChild.setChildParent(parent);
        return childRepository.saveAndFlush(newChild);
    }
    @Override
    public List<Child> getChildrenByParentId(int parentId)
    {
        Person parent=personRepository.findOne(parentId);
        return childRepository.getChildrenByChildParent(parent);
    }
}
