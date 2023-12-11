package com.example.tests;

import org.junit.jupiter.api.Test;
import com.example.entity.Order;
import com.example.entity.CloudUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setOrderId(1L);
        order.setDate(LocalDate.now());
        order.setTotalAmount(100.0);

        assertEquals(1L, order.getOrderId());
        // Assert other properties as needed
    }

    @Test
    public void testSettersAndGetters() {
        Order order = new Order();
        order.setOrderId(2L);
        order.setDate(LocalDate.now());
        order.setTotalAmount(200.0);

        assertEquals(2L, order.getOrderId());
        // Assert other properties as needed
    }
}
