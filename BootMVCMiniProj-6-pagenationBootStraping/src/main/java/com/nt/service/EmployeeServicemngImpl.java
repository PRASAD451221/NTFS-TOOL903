package com.nt.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nt.Entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeServicemngImpl implements IEmployeeMangService {

	@Autowired
	private IEmployeeRepository repo;
	@Override
	public Page<Employee> showAllEmployeesByPage(org.springframework.data.domain.Pageable pageable) {
//		List<Employee> it = StreamSupport.stream(repo.findAll().spliterator(), false).toList();
		
//		return it.stream().sorted((emp1,emp2)->emp1.getEmpname().compareTo(emp2.getEmpname())).toList();
//		return it.stream().sorted().toList();//perform natural sort
		
		
		Page<Employee> page = repo.findAll(pageable);
		return page;
	}
	@Override
	public String RegisterEmployee(Employee emp) 
	{
		int empno = repo.save(emp).getEmpno();
		return "the employee is register"+empno;
	}
	@Override
	public Employee getEmployeeByEmpno(int no) {
		Employee emp = repo.findById(no).orElseThrow(()->new IllegalArgumentException("no id avaliabe"));
		return emp;
	}
	@Override
	public String UpdateEmployee(Employee emp) {
		
		return "the employeee is saved id with ::"+repo.save(emp).getEmpno();
	}
	@Override
	public String deleteEmployeeByEmpno(int no) {
		repo.deleteById(no);
		return no+"employee is deleted here";
	}
	@Override
	public List<Employee> showEmployeeReportBySearch(Employee emp) {
		if(emp.getEmpname().equalsIgnoreCase("")||emp.getEmpname().length()==0)
			emp.setEmpname(null);
		if(emp.getJob().equalsIgnoreCase("")||emp.getJob().length()==0)
			emp.setJob(null);
		
		
		Example example =Example.of(emp);
	
		@SuppressWarnings("unchecked")
		List<Employee> list = repo.findAll(example);
		return list;
	}

}
