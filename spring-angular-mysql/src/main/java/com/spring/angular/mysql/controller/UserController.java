package com.spring.angular.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.mysql.dto.Dto;
import com.spring.angular.mysql.entity.UserEntity;
import com.spring.angular.mysql.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
		
		@Autowired
		UserService userService;
		


		@PostMapping("/user")
		public @ResponseBody List<UserEntity> addUser(@RequestBody Dto userDto) {
			 userService.addUser(userDto);
			 return userService.getUsers();
			
		}
		
		@GetMapping("/user")
		public List<UserEntity> getUser(){
			return userService.getUsers();
		}
		
		@DeleteMapping("/user/{id}")
		public List<UserEntity> deleteUser(@PathVariable int id) {
			 userService.deleteUser(id);
			 return userService.getUsers();
		}
		
}
