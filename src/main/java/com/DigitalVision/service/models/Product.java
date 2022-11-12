package com.DigitalVision.service.models;

import org.springframework.format.number.CurrencyStyleFormatter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String[] images;
    private String title;
    private String description;
    private String category;
    private String colour;
    private String brand;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(Long id, String[] images, String title, String description, String colour, String brand,String category, double price, int quantity) {
        this.id = id;
        this.images = images;
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String[] images, String title, String description, String colour, String brand ,String category, double price, int quantity) {
        this.images = images;
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
