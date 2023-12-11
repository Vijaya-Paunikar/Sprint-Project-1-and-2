package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Cart;
import com.example.repository.CartRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createCart(@RequestBody Cart cart) {
        try {
            // Log the received cart object
            System.out.println("Received Cart: " + cart);

            cartRepository.save(cart);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cart created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating cart");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCart(@PathVariable Long id, @RequestBody Cart updatedCart) {
        try {
            return cartRepository.findById(id)
                    .map(cart -> {
                        cart.setDate(updatedCart.getDate());
                        cart.setActive(updatedCart.isActive());
                        cart.setItemCount(updatedCart.getItemCount());
                        cart.setTotalAmount(updatedCart.getTotalAmount());
                        cart.setSpecialInstructions(updatedCart.getSpecialInstructions());
                        cart.setDeliveryAddress(updatedCart.getDeliveryAddress());
                        cartRepository.save(cart);
                        return ResponseEntity.ok("Cart updated successfully");
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating cart");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCart(@PathVariable Long id) {
        try {
            cartRepository.deleteById(id);
            return ResponseEntity.ok("Cart deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting cart");
        }
    }
}
