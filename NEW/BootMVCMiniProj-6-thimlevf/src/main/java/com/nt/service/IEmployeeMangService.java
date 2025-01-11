package com.nt.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.Entity.Employee;

public interface IEmployeeMangService {

	public Page<Employee> showAllEmployeesByPage(Pageable pageable);
	public String RegisterEmployee(Employee emp);
	public Employee getEmployeeByEmpno(int no);
	public String UpdateEmployee(Employee emp);
	public String deleteEmployeeByEmpno(int no);
	public List<Employee> showEmployeeReportBySearch(Employee emp);
}
