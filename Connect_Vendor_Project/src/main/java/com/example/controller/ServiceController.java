package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Service;
import com.example.repository.ServiceRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Service service = serviceRepository.findById(id).orElse(null);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createService(@RequestBody Service service) {
        try {
            serviceRepository.save(service);
            return ResponseEntity.status(HttpStatus.CREATED).body("Service created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating service");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateService(@PathVariable Long id, @RequestBody Service updatedService) {
        try {
            return serviceRepository.findById(id)
                    .map(service -> {
                        service.setName(updatedService.getName());
                        service.setDescription(updatedService.getDescription());
                        service.setPrice(updatedService.getPrice());
                        serviceRepository.save(service);
                        return ResponseEntity.ok("Service updated successfully");
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating service");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteService(@PathVariable Long id) {
        try {
            serviceRepository.deleteById(id);
            return ResponseEntity.ok("Service deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting service");
        }
    }
}
