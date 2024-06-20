package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;
import com.klef.jfsd.springboot.repository.EmployeeRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Admin checkAdminLogin(String username, String password) 
	{
		return adminRepository.checkAdminLogin(username, password);
	}

	@Override
	public List<Customer> viewAllCustomers() 
	{
		return customerRepository.findAll();
	}

	@Override
	public String deleteCustomer(int id) 
	{
		Optional<Customer> customer = customerRepository.findById(id);
		String msg = null;
		if(customer.isPresent())
		{
			Customer cust = customer.get();
			customerRepository.delete(cust);
			msg = "Customer Deleted Successfully";
		}
		else
		{
			msg = "Customer Not Found";
		}
		return msg;
	}

	@Override
	public Customer viewCustomerById(int id) 
	{
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
		{
			Customer cust = customer.get();
			return cust;
		}
		else
		{
			return null;
		}
	}

	@Override
	public long empcount()
	{
		return employeeRepository.count();
	}

	@Override
	public long customercount()
	{
		return customerRepository.count();
	}

	@Override
	public List<Employee> viewallemployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee viewemployeebyid(int eid)
	{
		Optional<Employee> obj =  employeeRepository.findById(eid);
        
        if(obj.isPresent())
        {
          Employee emp = obj.get();
          
          return emp;
        }
        else
        {
          return null;
        }
	}

	@Override
	public int updatestatus(boolean status, int eid)
	{
		return adminRepository.updatestatus(status, eid);
	}

	
}
