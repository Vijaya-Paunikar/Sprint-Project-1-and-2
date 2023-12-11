package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan(basePackages = {"com.example", "com.example.controller", "com.example.services"})
public class ConnectVendorProjectApplication
{

    public static void main(String[] args) 
    {
        SpringApplication.run(ConnectVendorProjectApplication.class, args);
    }

}

