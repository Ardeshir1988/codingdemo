package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.service.ChildService;
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

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ChildRestController.class)
public class ChildRestControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private ChildService childService;
    @InjectMocks
    private ChildRestController childRestControllerTest;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(childRestControllerTest).build();
    }
    @Test
    public void getChildrenByParent()throws Exception
    {
        Set<Child> children =new HashSet<>();
        Person parent=new Person();
        parent.setPersonId(7);
        parent.setPersonName("jack");
        parent.setPersonGender("male");
        Child alex=new Child();
        alex.setChildId(1);
        alex.setChildAge(5);
        alex.setChildGender("male");
        alex.setChildName("alex");
        alex.setChildParent(parent);
        Child julia=new Child();
        julia.setChildId(2);
        julia.setChildName("julia");
        julia.setChildGender("female");
        julia.setChildAge(7);
        julia.setChildParent(parent);
        children.add(alex);
        children.add(julia);
        parent.setChildren(children);

        given(childService.getChildrenByParentId(7)).willReturn(Arrays.asList(alex,julia));
        mockMvc.perform(get("/api/child/getchildren?parentid=7")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].childName",is("alex")))
                .andExpect(jsonPath("$[1].childName",is("julia")));
    }
}
