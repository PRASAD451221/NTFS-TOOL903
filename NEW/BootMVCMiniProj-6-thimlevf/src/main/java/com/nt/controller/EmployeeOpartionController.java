package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.Entity.Employee;
import com.nt.service.IEmployeeMangService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/employee")
public class EmployeeOpartionController {
	@Autowired
	private IEmployeeMangService service;
	
	
	
	@GetMapping("/home")
	public String showHomePage()
	{
		return"welcome";
	}
	
	@GetMapping("/report")
	public String showReport(@PageableDefault(page=0,size = 5,sort = "job",direction = Sort.Direction.ASC)Pageable pageable,Map<String, Object> map)
	{
		try
		{
		Page<Employee> page = service.showAllEmployeesByPage(pageable);
		
		map.put("pageData", page);
		return"show_report";
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put("erroemsg", e.getMessage());
			return "error";
		}
	}
	@GetMapping("/register") //for the form launching
	
	public String ShowEmployeeRegistrationPage(@ModelAttribute("emp") Employee emp)
	{
		return "Employee_Register";
	}
	
	/*@PostMapping("/register")// for the storing the form page
	public String RegisterEmployeeController(Map<String, Object> map,@ModelAttribute("emp") Employee emp)
	{
		try
		{
			String msg = service.RegisterEmployee(emp);
			List<Employee> list = service.showAllEmployees();
			map.put("emplist",list);
			
			map.put("msglist",msg);
			
			return"show_report";	
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put("erroemsg", e.getMessage());
			return "error";
		}
	}*/
	/*@PostMapping("/register")// for the storing the form page
	public String RegisterEmployeeController(Map<String, Object> map,@ModelAttribute("emp") Employee emp)
	{
		try
		{
			String msg = service.RegisterEmployee(emp);
			
			
			map.put("msglist",msg);
			
			return"redirect:report";	
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put("erroemsg", e.getMessage());
			return "error";
		}*/
	
	
	
	/*@PostMapping("/register")// for the storing the form page
	public String RegisterEmployeeController(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs)
	{
		try
		{
			System.out.println("EmployeeOpartionController.RegisterEmployeeController()");
			String msg = service.RegisterEmployee(emp);
			
			
			attrs.addFlashAttribute("msglist",msg);
			
			return"redirect:report";	
		}
		catch (Exception e) {
			e.printStackTrace();
			attrs.addFlashAttribute("erroemsg", e.getMessage());
			return "error";
		}*/
	
	
	
	@PostMapping("/register")// for the storing the form page
	public String RegisterEmployeeController(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs)
	{
		try {
	        String msg = service.RegisterEmployee(emp);
	        attrs.addFlashAttribute("msg", "Employee registered successfully: " + emp.getEmpname());
	        return "redirect:report";
	    } catch (Exception e) {
	        e.printStackTrace();
	        attrs.addFlashAttribute("error", "Failed to register employee: " + e.getMessage());
	        return "redirect:report";
	    }
	
	
	
	}
	
	
	@GetMapping("/edit")
	public String EditEmployee(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp)
	{
		Employee emp1 = service.getEmployeeByEmpno(no);
		BeanUtils.copyProperties(emp1, emp);
		
		return "update_Employee";
	}
	
	
	@PostMapping("/edit")
	public String EditEmployeeDetails(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp)
	{
		 try {
		        String msg = service.UpdateEmployee(emp);
		        attrs.addFlashAttribute("msg", "Employee updated successfully: " + emp.getEmpname());
		        return "redirect:report";
		    } catch (Exception e) {
		        e.printStackTrace();
		        attrs.addFlashAttribute("error", "Failed to update employee: " + e.getMessage());
		        return "redirect:report";
		    }
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(Map<String, Object> map,@RequestParam int no)
	{
		try
		{
		String msg = service.deleteEmployeeByEmpno(no);
		map.put("emplist", msg);
		return "forward:report";
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put("erroemsg", e.getMessage());
			return "error";
		}
	}
	
	@PostMapping("/search")
	public String showReportBySearchEmployee(@ModelAttribute("emp") Employee emp,Map<String, Object> map)
	{
		try
		{
			List<Employee> list = service.showEmployeeReportBySearch(emp);
			map.put("emplist", list);
		
		return "show_report";
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put("erroemsg", e.getMessage());
			return "error";
		}
		
	}


}

