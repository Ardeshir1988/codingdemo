package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class PersonRestControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @InjectMocks
    private PersonRestController personRestControllerTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(personRestControllerTest).build();
    }

    @Test
    public void getAllPeopleTest() throws Exception
    {
        Person alex = new Person();
        alex.setPersonId(1);
        alex.setPersonName("alex");
        alex.setPersonGender("male");
        alex.setPersonAge(20);
        List<Person> people = Arrays.asList(alex);
        given(personService.getAllPeople()).willReturn(people);
        mockMvc.perform(get("/api/person/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].personName",is("alex")));
    }
    @Test
    public void addNewPersonTest ()throws Exception
    {
        Person alex = new Person();
        alex.setPersonId(1);
        alex.setPersonName("alex");
        alex.setPersonGender("male");
        alex.setPersonAge(30);
        given(personService.addNewPerson("alex",30,"male")).willReturn(alex);
        mockMvc.perform(get("/api/person/addperson?name=alex&age=30&gender=male")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personName",is("alex")))
                .andExpect(jsonPath("$.personAge",is(30)))
                .andExpect(jsonPath("$.personGender",is("male")));
    }

}
