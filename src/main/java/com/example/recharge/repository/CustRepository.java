package com.example.recharge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.recharge.entity.Customer;

@Repository
public interface CustRepository extends JpaRepository<Customer, String>{

	public Customer findByEmailId(String emailId);
	

}
