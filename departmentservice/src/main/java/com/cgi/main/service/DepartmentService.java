package com.cgi.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.main.entity.Department;
import com.cgi.main.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return this.departmentRepository.save(department);

	}

	public Department findDepartmentById(int did) {
		// TODO Auto-generated method stub
		Optional<Department> op = this.departmentRepository.findById(did);

		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}
}
