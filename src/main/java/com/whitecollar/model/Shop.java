package com.whitecollar.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "storage_capacity")
    private int storageCapacity;
    @Column(name = "pictures")
    @ElementCollection
    private List<Picture> pictures;

    public Shop(){}

    public Shop(String name, int storageCapacity) {
        this.name = name;
        this.storageCapacity = storageCapacity;
    }

    public Shop(String name, int storageCapacity, List<Picture> pictures) {
        this.name = name;
        this.storageCapacity = storageCapacity;
        this.pictures = pictures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
