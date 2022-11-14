package com.DigitalVision.service.dtos;


public class SearchDTO {
    private String query;
    private double minPrice;
    private double maxPrice;
    private String category;

    public SearchDTO(String query, double minPrice, double maxPrice, String category) {
        this.query = query;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.category = category;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
