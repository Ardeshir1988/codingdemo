package com.ardeshir.codingdemo.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "house")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "houseId")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_id")
    private int houseId;

    @Column(name = "house_type")
    @Enumerated(EnumType.STRING)
    private HouseType houseType;


    @Column(name = "house_address")
    private String houseAddress;

    @Column(name = "house_room")
    private int houseRoom;

    @OneToOne
    @JoinColumn(name = "house_person_id")
    private Person houseOwner;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public int getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(int houseRoom) {
        this.houseRoom = houseRoom;
    }

    public Person getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(Person houseOwner) {
        this.houseOwner = houseOwner;
    }
}
