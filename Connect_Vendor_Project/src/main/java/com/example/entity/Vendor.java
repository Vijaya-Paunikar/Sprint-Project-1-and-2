package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Vendor 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorID;

    private String vendorName;
    private String description;

    @Column(unique = true)
    private Long contact;

    public Vendor() {
        // Default constructor
    }

    public Vendor(Long vendorID, String vendorName, String description, Long contact) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.description = description;
        this.contact = contact;
    }

    public Long getVendorID() {
        return vendorID;
    }

    public void setVendorID(Long vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getContact() {
        return contact;
    }
    
    public void setContact(long contact) {
        this.contact = contact;
    }
  
}
