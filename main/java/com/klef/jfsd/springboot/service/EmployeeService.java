package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.model.Employee;

public interface EmployeeService
{
	public String addemployee(Employee employee);
	public String updateemployee(Employee emp);
	public Employee viewempbyid(int eid);
	public Employee checkemplogin(String email,String pwd);
}