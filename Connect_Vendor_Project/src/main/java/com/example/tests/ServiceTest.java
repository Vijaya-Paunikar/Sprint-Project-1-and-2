package com.example.tests;

import org.junit.jupiter.api.Test;
import com.example.entity.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    public void testCreateService() {
        Service service = new Service();
        service.setServiceID(1L);
        service.setName("TestService");
        service.setDescription("Test Description");
        service.setPrice(50.0);

        assertEquals(1L, service.getServiceID());
        assertEquals("TestService", service.getName());
        assertEquals("Test Description", service.getDescription());
        assertEquals(50.0, service.getPrice());
    }

    @Test
    public void testSettersAndGetters() {
        Service service = new Service();
        service.setServiceID(2L);
        service.setName("AnotherService");
        service.setDescription("Another Description");
        service.setPrice(75.0);

        assertEquals(2L, service.getServiceID());
        assertEquals("AnotherService", service.getName());
        assertEquals("Another Description", service.getDescription());
        assertEquals(75.0, service.getPrice());
    }
}
