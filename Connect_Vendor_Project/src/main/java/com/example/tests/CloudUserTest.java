package com.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.entity.CloudUser;

public class CloudUserTest 
{

    @Test
    public void testCreateCloudUser() {
        CloudUser user = new CloudUser();
        user.setUserId(1L);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("testpassword");

        assertEquals(1L, user.getUserId());
        assertEquals("testuser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("testpassword", user.getPassword());
    }

    @Test
    public void testSettersAndGetters() {
        CloudUser user = new CloudUser();
        user.setUserId(2L);
        user.setUsername("anotheruser");
        user.setEmail("another@example.com");
        user.setPassword("anotherpassword");

        assertEquals(2L, user.getUserId());
        assertEquals("anotheruser", user.getUsername());
        assertEquals("another@example.com", user.getEmail());
        assertEquals("anotherpassword", user.getPassword());
    }
}

