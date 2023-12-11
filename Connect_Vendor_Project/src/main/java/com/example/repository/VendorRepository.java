package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>
{

	boolean existsByContact(Long contact);

	boolean existsByContactAndVendorIDNot(Long contact, Long vendorID);
	
}
