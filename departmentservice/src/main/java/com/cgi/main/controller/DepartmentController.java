package com.cgi.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.main.entity.Department;
import com.cgi.main.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
	{
		 Department department1 = this.departmentService.saveDepartment(department);
		return new ResponseEntity<>(department1,HttpStatus.OK);
	}
	
	@GetMapping("/{did}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("did") int did)
	{
		Department department = this.departmentService.findDepartmentById(did);
					
		return new ResponseEntity<Department>(department,HttpStatus.OK);
	}
}
