package com.example.tests;

import org.junit.jupiter.api.Test;
import com.example.entity.Role;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    @Test
    public void testCreateRole() {
        Role role = new Role();
        role.setRoleID(1L);
        role.setRoleName("TestRole");
        role.setDescription("Test Description");

        assertEquals(1L, role.getRoleID());
        assertEquals("TestRole", role.getRoleName());
        assertEquals("Test Description", role.getDescription());
    }

    @Test
    public void testSettersAndGetters() {
        Role role = new Role();
        role.setRoleID(2L);
        role.setRoleName("AnotherRole");
        role.setDescription("Another Description");

        assertEquals(2L, role.getRoleID());
        assertEquals("AnotherRole", role.getRoleName());
        assertEquals("Another Description", role.getDescription());
    }
}
