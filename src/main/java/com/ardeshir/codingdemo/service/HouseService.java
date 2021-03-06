package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.HouseType;
import com.ardeshir.codingdemo.model.Person;
import com.ardeshir.codingdemo.repository.HouseRepository;
import com.ardeshir.codingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HouseService implements IHouseService{

    private HouseRepository houseRepository;
    private PersonRepository personRepository;
    @Autowired
    private void HouseServiceSetterInjection(HouseRepository houseRepository, PersonRepository personRepository)
    {
        this.houseRepository=houseRepository;
        this.personRepository=personRepository;
    }
    @Override
    public List<House> getAllHouses()
    {
        return houseRepository.findAll();
    }
    @Override
    public House updateHouses(int id, HouseType houseType, String address, int room)
    {
        House house=houseRepository.findOne(id);
        house.setHouseType(houseType);
        house.setHouseAddress(address);
        house.setHouseRoom(room);
        return houseRepository.saveAndFlush(house);
    }
    @Override
    public House addHouses(HouseType houseType, String address, int room, int ownerId)
    {
        House house=new House();
        house.setHouseType(houseType);
        house.setHouseAddress(address);
        house.setHouseRoom(room);
        Person owner=personRepository.findOne(ownerId);
        house.setHouseOwner(owner);
        return houseRepository.saveAndFlush(house);
    }
    @Override
    public House findHouseByPersonId(int personId)
    {
        return houseRepository.findByHouseOwnerId(personId);
    }
}
