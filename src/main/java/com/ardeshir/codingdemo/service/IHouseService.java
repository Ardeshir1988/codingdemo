package com.ardeshir.codingdemo.service;

import com.ardeshir.codingdemo.model.House;
import com.ardeshir.codingdemo.model.HouseType;

import java.util.List;

public interface IHouseService {
    List<House> getAllHouses();
    House updateHouses(int id, HouseType houseType, String address, int room);
    House addHouses(HouseType houseType, String address, int room, int ownerId);
    House findHouseByPersonId(int personId);
}
