package com.ardeshir.codingdemo.controller;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.HouseType;
import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.service.HouseService;
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

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HouseRestController.class)
public class HouseRestControllerTest {

    private MockMvc mockMvc;
    @MockBean
    private HouseService houseService;
    @InjectMocks
    private HouseRestController houseRestControllerTest;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(houseRestControllerTest).build();
    }
    @Test
    public void updateHousesTest() throws Exception
    {
        House house=new House();
        house.setHouseId(1);
        house.setHouseType(HouseType.Apartment);
        house.setHouseAddress("wallstreet");
        house.setHouseRoom(2);
        Person owner=new Person();
        owner.setHouse(house);
        owner.setPersonId(1);
        owner.setPersonGender("male");
        owner.setPersonName("ardeshir");
        house.setHouseOwner(owner);

        given(houseService.updateHouses(1,HouseType.Apartment,"wallstreet",2)).willReturn(house);
        mockMvc.perform(get("/api/house/updatehouse?id=1&housetype=Apartment&address=wallstreet&room=2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.houseAddress",is("wallstreet")))
                .andExpect(jsonPath("$.houseType",is("Apartment")))
                .andExpect(jsonPath("$.houseRoom",is(2)));
    }
}
