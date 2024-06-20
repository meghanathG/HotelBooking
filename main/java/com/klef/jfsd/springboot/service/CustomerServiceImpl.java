package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String addCustomer(Customer customer) 
	{
		customerRepository.save(customer);
		return "Customer Registered Successfull";
	}

	@Override
	public Customer checkCustomerLogin(String email, String password) 
	{
		return customerRepository.checkCustomerLogin(email, password);
	}

}
