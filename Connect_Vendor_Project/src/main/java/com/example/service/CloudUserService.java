package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CloudUser;
import com.example.repository.CloudUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CloudUserService {

    @Autowired
    private CloudUserRepository userRepository;

    public List<CloudUser> getAllUsers() {
        return (List<CloudUser>) userRepository.findAll();
    }

    public Optional<CloudUser> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public CloudUser createUser(CloudUser user) {
        return userRepository.save(user);
    }

    public CloudUser updateUser(Long userId, CloudUser user) {
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
