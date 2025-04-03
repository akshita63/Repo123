package com.exampleProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleProject.Service.EmployeeService;
import com.exampleProject.entity.employeePojoo;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<employeePojoo> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
    public employeePojoo getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
	
	@PostMapping
	public employeePojoo createEmployee(@RequestBody employeePojoo employee) {
		return employeeService.saveEmployee(employee);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        String msg="deleted the particular id";
        return ResponseEntity.ok(msg);
    }
	
	

}
