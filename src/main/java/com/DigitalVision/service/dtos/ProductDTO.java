package com.DigitalVision.service.dtos;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {

    private List<String> images;
    private String title;
    private String description;
    private String colour;
    private String brand;
    private BigDecimal price;
    private int quantity;

    public ProductDTO(List<String> images, String title, String description, String colour, String brand, BigDecimal price, int quantity) {
        this.images = images;
        this.title = title;
        this.description = description;
        this.colour = colour;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
