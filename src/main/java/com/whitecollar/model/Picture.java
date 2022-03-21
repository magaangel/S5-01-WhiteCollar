package com.whitecollar.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "author")
    private String author;
    @Column (name = "price")
    private double price;
    @Column (name = "entry_date")
    private String entryDate;

    public Picture() {
    }

    public Picture(String name, String author, double price, String entryDate) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.entryDate = entryDate;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}
