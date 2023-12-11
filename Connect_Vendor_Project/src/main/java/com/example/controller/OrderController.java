package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Order;
import com.example.repository.OrderRepository;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            orderRepository.save(order);
            return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        try {
            return orderRepository.findById(id)
                    .map(order -> {
                        order.setDate(updatedOrder.getDate());
                        order.setTotalAmount(updatedOrder.getTotalAmount());
                        orderRepository.save(order);
                        return ResponseEntity.ok("Order updated successfully");
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating order");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        try {
            orderRepository.deleteById(id);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order");
        }
    }
}
