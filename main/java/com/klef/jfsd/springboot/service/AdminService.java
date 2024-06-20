package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Employee;

public interface AdminService 
{
	public List<Customer> viewAllCustomers();
	public String deleteCustomer(int id);
	public Customer viewCustomerById(int id);
	public Admin checkAdminLogin(String username, String password);
	
	public long empcount();
	public long customercount();
	public List<Employee> viewallemployees();
	public Employee viewemployeebyid(int eid);
	public int updatestatus(boolean status, int eid);
}
