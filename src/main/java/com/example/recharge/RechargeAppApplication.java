package com.example.recharge;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.recharge.entity.Customer;
import com.example.recharge.service.CustomerService;
import com.example.recharge.service.CustomerSeviceImpl;

@SpringBootApplication
public class RechargeAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con=SpringApplication.run(RechargeAppApplication.class, args);
		CustomerService cs=con.getBean(CustomerSeviceImpl.class);
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("[1] Register \n[2] Display \n[3] Login \n[4] Recharge");
			System.out.println("Enter your choice : ");
			int ch=sc.nextInt();
			switch (ch) {
				case 1:
					System.out.println("Enter Account number : ");
					int accNo=sc.nextInt();
					System.out.println("Enter Customer name : ");
					String custName=sc.next();
					System.out.println("Enter Email ID : ");
					String emailId=sc.next();
					System.out.println("Enter Mobile Number : ");
					long mobNo=sc.nextLong();
					System.out.println("Enter Account Balance : ");
					double accBal=sc.nextDouble();
					System.out.println("Enter password : ");
					String password=sc.next();
					cs.registerCustomer(new Customer(accNo, custName, emailId, password, mobNo, accBal));
				break;
				
				case 2:
					List<Customer> custLst=cs.getAllCustomers();
					for(Customer c:custLst) {
						System.out.println(c);
					}
				break;
				
				case 3:
					System.out.println("Enter Email ID : ");
					emailId=sc.next();
					System.out.println("Enter password : ");
					password=sc.next();
					Customer cust=cs.Login(emailId,password);
				break;
				
				case 4://recharge
					System.out.println("Enter Email ID : ");
					emailId=sc.next();
					System.out.println("Enter password : ");
					password=sc.next();
					cust=cs.Login(emailId,password);
					if(cust!=null) {
						System.out.println("-------------------");
						System.out.println("1. Airtel\n2. VI\n3. Jio");
						System.out.println("-------------------");
						System.out.println("Select service provider : ");
						int sp=sc.nextInt();
						switch(sp) {
							case 1,2,3:
								System.out.println("Enter recharge amount : ");
								double amt=sc.nextDouble();
								if(amt<cust.getAccBal()) {
									double updatedBalance=cust.getAccBal()-amt;
									cust.setAccBal(updatedBalance);
									cs.updateCustomerByEmail(cust, emailId);
									System.out.println("\n\nRecharge of Rs."+amt+" is successful to your number "+cust.getMobNo());
								}
							break;
						}
					}
					else
					{
						System.out.println("Error...Try again");
					}
				break;
			}
			System.out.println("Continue? ");
		}while(sc.nextInt()==1);
		
	}

}
