package com.example.recharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.recharge.entity.Customer;
import com.example.recharge.repository.CustRepository;

@Service
public class CustomerSeviceImpl implements CustomerService{

	@Autowired
	private CustRepository custRepo;
	
	@Override
	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

	@Override
	public Customer getCustomerByEmail(String emailId) {
		Customer cust=null;
		try {
			cust=custRepo.findByEmailId(emailId);
		}
		catch(Exception e) {}
		return cust;
	}

	@Override
	public Customer registerCustomer(Customer cust) {
		Customer c=custRepo.save(cust);
		return c;
	}

	@Override
	public Customer recharge(String email ,int ammount ) {
		
		Customer cust = custRepo.findByEmailId(email);
		if(cust.getAccBal()>=ammount) {
			custRepo.deleteById(email);
			cust.setAccBal(cust.getAccBal()-ammount);
			return  custRepo.save(cust);
			
		}
		return null;
	}
	@Override 
	public Customer Login(String emailId,String password) {
		
		Customer cust=custRepo.findByEmailId(emailId);
		if(cust!=null) {
			
			if(cust.getPassword().equals(password)) {
				System.out.println("Login Successful..!!");
				System.out.println(cust);
				return cust;
			}else {
				cust=null;
			}
			
		}
		
		return cust;
		
	}

	@Override
	public Customer updateCustomerByEmail(Customer cust, String emailId) {
		cust.setEmailId(emailId);
		return custRepo.save(cust);
	}

	@Override
	public void deleteCustomer(String email) {
		custRepo.deleteById(email);
		
	}

	
	
}
