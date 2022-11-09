package com.DigitalVision.service.models;

import org.springframework.format.number.CurrencyStyleFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<String> images;
    private String title;
    private String description;
    private String colour;
    private String brand;
    private String price;
    private int quantity;

    public Product() {
    }

    public Product(Long id, List<String> images, String title, String description, String colour, String brand, String price, int quantity) {
        this.id = id;
        this.images = images;
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(List<String> images, String title, String description, String colour, String brand, String price, int quantity) {
        this.images = images;
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public String formatPrice(BigDecimal price) {
        CurrencyStyleFormatter formatter = new CurrencyStyleFormatter();
        formatter.setFractionDigits(0);
        return formatter.print(price, Locale.US);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
