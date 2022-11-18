package com.DigitalVision.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table

public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OrderId;
    private Long OrderProductId;
    private Long UserId;
    private double TotalPrice;
    private double DeliveryCharges;

    public Order() {
    }

    public Order(Long OrderId,Long OrderProductId,Long UserId, double TotalPrice, double DeliveryCharges) {
        this.OrderId = OrderId;
        this.OrderProductId = OrderProductId;
        this.UserId = UserId;
        this.DeliveryCharges = DeliveryCharges;
        this.TotalPrice = TotalPrice;


    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }

    public Long getOrderProductId() {
        return OrderProductId;
    }

    public void setOrderProductId(Long OrderProductId) {
        this.OrderProductId = OrderProductId;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public Double getDeliveryCharges() {
        return DeliveryCharges;
    }

    public void setDeliveryCharges(double DeliveryCharges) {
        this.DeliveryCharges = DeliveryCharges;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

}