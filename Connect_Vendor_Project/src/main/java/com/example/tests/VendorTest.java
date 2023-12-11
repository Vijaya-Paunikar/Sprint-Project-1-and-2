package com.example.tests;

import org.junit.jupiter.api.Test;

import com.example.entity.Vendor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest 
{

    @Test
    public void testCreateVendor() 
    {
        Vendor vendor = new Vendor();
        vendor.setVendorID(1L);
        vendor.setVendorName("TestVendor");
        vendor.setDescription("Test Description");
        vendor.setContact(1234567890L);

        assertEquals(1L, vendor.getVendorID());
        assertEquals("TestVendor", vendor.getVendorName());
        assertEquals("Test Description", vendor.getDescription());
        assertEquals(1234567890L, vendor.getContact());
    }

    @Test
    public void testSettersAndGetters() 
    {
        Vendor vendor = new Vendor();
        vendor.setVendorID(2L);
        vendor.setVendorName("AnotherVendor");
        vendor.setDescription("Another Description");
        vendor.setContact(9876543210L);

        assertEquals(2L, vendor.getVendorID());
        assertEquals("AnotherVendor", vendor.getVendorName());
        assertEquals("Another Description", vendor.getDescription());
        assertEquals(9876543210L, vendor.getContact());
    }
}

