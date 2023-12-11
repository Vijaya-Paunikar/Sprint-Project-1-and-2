package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carts")
public class Cart 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartID;

    private LocalDate date;

    private boolean isActive;
    private int itemCount;
    private double totalAmount;

    private String specialInstructions; // Any special instructions for the cart
    private String deliveryAddress; // Address where the items in the cart should be delivered

    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Cart(Long cartID, LocalDate date, boolean isActive, int itemCount, double totalAmount,
                String specialInstructions, String deliveryAddress) {
        super();
        this.cartID = cartID;
        this.date = date;
        this.isActive = isActive;
        this.itemCount = itemCount;
        this.totalAmount = totalAmount;
        this.specialInstructions = specialInstructions;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getTotalAmount() 
    {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSpecialInstructions() 
    {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getDeliveryAddress() 
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
