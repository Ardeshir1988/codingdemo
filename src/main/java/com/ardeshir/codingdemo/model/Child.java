package com.ardeshir.codingdemo.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "child")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "childId")
public class Child implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "child_id")
    private int childId;
    @Column(name = "child_name")
    private String childName;
    @Column(name = "child_age")
    private int childAge;
    @Column(name = "child_gender")
    private String childGender;
    @Column(name = "child_school_name")
    private String childSchoolName;
    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name = "child_parent_id")
    private Person childParent;


    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    public String getChildGender() {
        return childGender;
    }

    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }

    public String getChildSchoolName() {
        return childSchoolName;
    }

    public void setChildSchoolName(String childSchoolName) {
        this.childSchoolName = childSchoolName;
    }

    public Person getChildParent() {
        return childParent;
    }

    public void setChildParent(Person childParent) {
        this.childParent = childParent;
    }

}
