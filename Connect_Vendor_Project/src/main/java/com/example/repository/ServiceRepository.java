package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndServiceIDNot(String name, Long serviceID);
	List<Service> findAll();
}
