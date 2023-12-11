package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Vendor;
import com.example.repository.VendorRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/vendors")
public class VendorController 
{

    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        Vendor vendor = vendorRepository.findById(id).orElse(null);
        if (vendor != null) {
            return ResponseEntity.ok(vendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createVendor(@RequestBody Vendor vendor) {
        try {
            // Log the received vendor object
            System.out.println("Received Vendor: " + vendor);

            vendorRepository.save(vendor);
            return ResponseEntity.status(HttpStatus.CREATED).body("Vendor created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Phone Number Already exists.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
        try {
            return vendorRepository.findById(id)
                    .map(vendor -> {
                        vendor.setVendorName(updatedVendor.getVendorName());
                        vendor.setDescription(updatedVendor.getDescription());
                        vendor.setContact(updatedVendor.getContact());
                        vendorRepository.save(vendor);
                        return ResponseEntity.ok("Vendor updated successfully");
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating vendor");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVendor(@PathVariable Long id) {
        try {
            vendorRepository.deleteById(id);
            return ResponseEntity.ok("Vendor deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting vendor");
        }
    }
}
