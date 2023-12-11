package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.CloudUser;

public interface CloudUserRepository extends CrudRepository<CloudUser, Long> {
    // You can add custom queries if needed
}

