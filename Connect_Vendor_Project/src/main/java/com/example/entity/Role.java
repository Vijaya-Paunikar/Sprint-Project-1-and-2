package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleID;

    @Column(unique = true)
    private String roleName;

    private String description;

    public Role() {
        // Default constructor
    }

    public Role(Long roleID, String roleName, String description) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.description = description;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
