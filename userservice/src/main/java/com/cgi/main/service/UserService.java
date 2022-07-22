package com.cgi.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cgi.main.entity.User;
import com.cgi.main.repository.UserRepository;
import com.cgi.main.template.Department;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id).get();
	}

	public Department getDepartmentDetailsById(int id) {
		// TODO Auto-generated method stub
		// Here we need to call the another service
		// in order to get the department details
		// through the url(http://localhost:7002/departments/1)
		//Department department = 
		//this.restTemplate.getForObject("http://localhost:7002/departments/"+id,Department.class);
		Department department = 
				this.restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+id, 
						Department.class);
		
		return department;
	}

}
