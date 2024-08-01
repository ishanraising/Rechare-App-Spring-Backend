package com.example.recharge.service;

import java.util.List;

import com.example.recharge.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerByEmail(String emailId);
	public Customer registerCustomer(Customer cust);
	public Customer recharge(String email , int ammount);
	public Customer Login(String emailId, String password);
	public Customer updateCustomerByEmail(Customer cust,String emailId);
	public void deleteCustomer(String email);
	
	
	
}
