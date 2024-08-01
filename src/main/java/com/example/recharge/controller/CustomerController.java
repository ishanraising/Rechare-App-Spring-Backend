package com.example.recharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.recharge.entity.Customer;
import com.example.recharge.repository.CustRepository;
import com.example.recharge.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers() {
		return cs.getAllCustomers();
	}
	
	@PostMapping("/customer")
	public Customer registerCustomer(@RequestBody Customer cust) {
		return cs.registerCustomer(cust);
	}
	
	@GetMapping("/customer/{Email}/{Pass}")
	public Customer login(@PathVariable("Email") String email,@PathVariable("Pass") String pass) {
		return cs.Login(email, pass);
	}
	@PutMapping("/customer/recharge/{Email}/{Ammount}")
	public Customer recharge(@PathVariable("Email") String email, @PathVariable("Ammount") String ammount) {
		System.out.println(email);
		System.out.println(ammount);
		int newAmt=Integer.parseInt(ammount);
		return cs.recharge(email,newAmt);
	}
	
}
