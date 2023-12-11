package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.CloudUser;
import com.example.exception.CloudUserNotFoundException;
import com.example.service.CloudUserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class CloudUserController {

    @Autowired
    private CloudUserService userService;

    @GetMapping
    public List<CloudUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CloudUser> getUserById(@PathVariable Long userId) {
        Optional<CloudUser> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseThrow(() -> new CloudUserNotFoundException("User not found with id: " + userId));
    }

    @PostMapping
    public CloudUser createUser(@RequestBody CloudUser user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CloudUser> updateUser(@PathVariable Long userId, @RequestBody CloudUser user) {
        try {
            CloudUser updatedUser = userService.updateUser(userId, user);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            throw new CloudUserNotFoundException("User not found with id: " + userId);
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
