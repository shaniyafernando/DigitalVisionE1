package com.DigitalVision.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table

public class OrderedProducts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long ProductId;
    private int QuantityBought;

    public OrderedProducts() {
    }

    public OrderedProducts(Long Id,Long ProductId,int QuantityBought) {
        this.Id = Id;
        this.ProductId = ProductId;
        this.QuantityBought = QuantityBought;
    }

    public Long Id() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long ProductId) {
        this.ProductId = ProductId;
    }

    public double getQuantityBought() {
        return QuantityBought;
    }

    public void setQuantityBought(int QuantityBought) {
        this.QuantityBought = QuantityBought;
    }

}