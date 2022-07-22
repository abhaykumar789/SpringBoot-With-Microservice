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

import com.cgi.main.entity.User;
import com.cgi.main.service.UserService;
import com.cgi.main.template.Department;
import com.cgi.main.template.ResponseTemplate;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1 = this.userService.saveUser(user);

		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@GetMapping("/{userid}")
	public ResponseTemplate getUserWithDepartmentDetails(@PathVariable("userid") int userid) {
		//Write the logic to fetch  the details
		//Both User Details
		//and 
		//Department Details
		//This both Details we need to bind inside the ResponseEntity
		ResponseTemplate rt=new ResponseTemplate();
		User user = this.userService.getUserById(userid);
		Department department = this.userService.getDepartmentDetailsById(user.getDid());
		     
		//Store Both User and Department Objects 
		//Inside the ResponseTemlate
		rt.setUser(user);
		rt.setDepartment(department);
		return rt;
	}
	
	
	
}
