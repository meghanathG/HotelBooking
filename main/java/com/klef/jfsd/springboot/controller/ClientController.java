package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.CustomerService;
import com.klef.jfsd.springboot.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String main()
	{
		return "index";
	}
	
	@GetMapping("adminlogin")
	public ModelAndView adminLogin()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkAdminLogin(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		Admin admin = adminService.checkAdminLogin(username, password);
		if(admin != null)
		{
			modelAndView.setViewName("adminhome");
			
			   long ecount = adminService.empcount();
			   long ccount = adminService.customercount();
			   
			   modelAndView.addObject("ecount", ecount);
			   modelAndView.addObject("ccount",ccount);
		}
		else
		{
			modelAndView.setViewName("admin");
			modelAndView.addObject("message", "Login Failed");
		}
		return modelAndView;
	}
	
	@GetMapping("adminHome")
	public ModelAndView adminHome()
	{
		   long ecount = adminService.empcount();
		   long ccount = adminService.customercount();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminhome");
		modelAndView.addObject("ecount", ecount);
		modelAndView.addObject("ccount",ccount);
		return modelAndView;
	}
	
	@GetMapping("viewcustomers")
	public ModelAndView viewCustomers()
	{
		ModelAndView modelAndView = new ModelAndView("viewallcustomers");
		List<Customer> list = adminService.viewAllCustomers();
		modelAndView.addObject("custdata", list);
		return modelAndView;
	}
	
	@GetMapping("view")
	public ModelAndView viewCustomerByID(@RequestParam("id") int id)
	{
		Customer customer = adminService.viewCustomerById(id);
		ModelAndView modelAndView = new ModelAndView("viewcustbyid");
		modelAndView.addObject("custdata", customer);
		return modelAndView;
	}
	
	@GetMapping("deleteCustomer")
	public ModelAndView deleteCustomer()
	{
		ModelAndView modelAndView = new ModelAndView("deletecustomer");
		List<Customer> list = adminService.viewAllCustomers();
		modelAndView.addObject("custdata", list);
		return modelAndView;
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("id") int id)
	{
		adminService.deleteCustomer(id);
		return "redirect:/deleteCustomer";
	}
	
	@GetMapping("custreg")
	public ModelAndView customerRegister()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@PostMapping("insertcustomer")
	public ModelAndView insertcustomer(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String msg = null;
		try
		{
			String name = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Customer customer = new Customer();
			customer.setName(name);
			customer.setEmail(email);
			customer.setPassword(password);
			
			msg = customerService.addCustomer(customer);
			modelAndView.setViewName("register");
			modelAndView.addObject("message", msg);
		}
		catch(Exception e)
		{
			msg = "Customer Registration Not Successfull";
			modelAndView.setViewName("register");
			modelAndView.addObject("message", msg);
		}
		return modelAndView;
	}
	
	@GetMapping("custlogin")
	public ModelAndView customerLogin()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@PostMapping("checkcustlogin")
	public ModelAndView checkCustLogin(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = customerService.checkCustomerLogin(email, password);
		if(customer != null)
		{
			modelAndView.setViewName("customerhome");
		}
		else
		{
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "Login Failed");
		}
		return modelAndView;
	}
	
	@GetMapping("custhome")
	public ModelAndView custHome()
	{
		ModelAndView modelAndView = new ModelAndView("customerhome");
		return modelAndView;
	}
	@GetMapping("custfacilities")
	public ModelAndView custFacilities()
	{
		ModelAndView modelAndView = new ModelAndView("customerfacilities");
		return modelAndView;
	}
	@GetMapping("custcontact")
	public ModelAndView custContact()
	{
		ModelAndView modelAndView = new ModelAndView("contactus");
		return modelAndView;
	}
	
	
	@GetMapping("emplogin") 
	   public ModelAndView emplogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("emplogin");
	     return mv;
	   }
	   
	   @PostMapping("checkemplogin")
	   public ModelAndView checkemplogin(HttpServletRequest request)
	   {
	     ModelAndView mv = new ModelAndView();
	     
	     String email = request.getParameter("email");
	     String pwd = request.getParameter("pwd");
	     
	       Employee emp = employeeService.checkemplogin(email, pwd);
	       
	       if(emp!=null)
	       {
	    	   // session
	    	   HttpSession session = request.getSession();
	    	   session.setAttribute("eid", emp.getId()); 
	    	   session.setAttribute("ename", emp.getName());
	    	   //session
	         
	         mv.setViewName("emphome");
	       }
	       else
	       {
	         mv.setViewName("emplogin");
	         mv.addObject("message", "Login Failed");
	       }
	       
	       return mv;
	   }
	   
	   
	   @GetMapping("empreg")
	   public ModelAndView empreg()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("empreg");
	     return mv;
	   }
	
	@PostMapping("insertemp")
	public ModelAndView insert(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String msg = null;
		try
		{
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String dept = request.getParameter("dept");
			String sal = request.getParameter("salary");
			double salary = Double.parseDouble(sal);
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			String location = request.getParameter("location");
			String contact = request.getParameter("contact");
			
			Employee emp = new Employee();
			emp.setName(name);
			emp.setGender(gender);
			emp.setDateofbirth(dob);
			emp.setDepartment(dept);
			emp.setSalary(salary);
			emp.setEmail(email);
			emp.setPassword(pwd);
			emp.setLocation(location);
			emp.setContact(contact);
			emp.setActive(true);
			
			
			msg = employeeService.addemployee(emp);
			
			mv.setViewName("displaymsg");
			mv.addObject("message", msg);
			
		}
		catch(Exception e)
		{
			msg = e.getMessage();
			
			mv.setViewName("displayerror");
			mv.addObject("message", msg);
		}
		return mv;
	}
	   
	   
	   @GetMapping("emphome")
	   public ModelAndView emphome(HttpServletRequest request)
	   {
		   HttpSession session = request.getSession();
		   
		   int eid = (int)session.getAttribute("eid"); 
		   String ename = (String)session.getAttribute("ename"); 
		   
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("emphome");
	     
	     mv.addObject("eid", eid);
	     mv.addObject("ename", ename);
	     
	     return mv;
	   }
	   
	   
	   @GetMapping("viewallemps")
	   public ModelAndView viewallemps()
	   {
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("viewallemployees");
		   
		   List<Employee> emplist= adminService.viewallemployees();
		   
		   mv.addObject("empdata", emplist);
		   
		   return mv;
	   }
	   
	   @GetMapping("view1")
	   public ModelAndView viewempdemo(@RequestParam("id") int eid)
	   {
	     Employee emp = adminService.viewemployeebyid(eid);
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewempbyid");
	     mv.addObject("emp", emp);
	     return mv;
	   }
	   
	   
	   @GetMapping("updatestatus")
	      public ModelAndView updatestatus()
	      {
	       ModelAndView mv = new ModelAndView();
	       
	      mv.setViewName("viewallemployees");
	      
	      List<Employee> emplist =  adminService.viewallemployees();
	      
	      mv.addObject("empdata", emplist);
	      
	      return mv;
	      
	      }
	    
	    @GetMapping("setstatus")
	      public ModelAndView setstatusaction(@RequestParam("id") int eid,@RequestParam("status") boolean status)
	      {
	        String msg = null;
	        
	         
	        int n = adminService.updatestatus(status, eid);
	        
	        
	          List<Employee> emplist =  adminService.viewallemployees();
	                    
	        
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("viewallemployees");
	        mv.addObject("empdata", emplist);
	       
	        
	        if(n>0)
	        {
	          msg = "Status Updated Successfully";
	          mv.addObject("message", msg);
	        }
	        else
	        {
	          msg = "Failed to Update Status";
	          mv.addObject("message", msg);
	        }
	        
	        return mv;
	      }
	   
}
