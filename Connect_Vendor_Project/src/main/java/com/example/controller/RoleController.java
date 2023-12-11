package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Role;
import com.example.repository.RoleRepository;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        try {
            roleRepository.save(role);
            return ResponseEntity.status(HttpStatus.CREATED).body("Role created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Role creation failed.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRole(@PathVariable Long id, @RequestBody Role updatedRole) {
        try {
            return roleRepository.findById(id)
                    .map(role -> {
                        role.setRoleName(updatedRole.getRoleName());
                        role.setDescription(updatedRole.getDescription());
                        roleRepository.save(role);
                        return ResponseEntity.ok("Role updated successfully");
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating role");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        try {
            roleRepository.deleteById(id);
            return ResponseEntity.ok("Role deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting role");
        }
    }
}
