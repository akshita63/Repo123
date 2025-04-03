package com.exampleProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleProject.Repository.EmployeeRepo;
import com.exampleProject.entity.employeePojoo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	 public employeePojoo saveEmployee(employeePojoo employee) {
	        return employeeRepo.save(employee);
	    }
	
	
	
	public List<employeePojoo> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public employeePojoo getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
	
	


