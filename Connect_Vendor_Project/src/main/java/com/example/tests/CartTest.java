package com.example.tests;

import org.junit.jupiter.api.Test;

import com.example.entity.Cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    public void testCreateCart() {
        Cart cart = new Cart();
        cart.setCartID(1L);
        // Set other properties as needed

        assertEquals(1L, cart.getCartID());
        // Add assertions for other properties
    }

    @Test
    public void testSettersAndGetters() {
        Cart cart = new Cart();
        cart.setCartID(2L);
        // Set other properties as needed

        assertEquals(2L, cart.getCartID());
        // Add assertions for other properties
    }
}
