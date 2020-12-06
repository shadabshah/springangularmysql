package com.spring.angular.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.angular.mysql.dto.Dto;
import com.spring.angular.mysql.entity.UserEntity;
import com.spring.angular.mysql.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

		@Autowired
		UserRepository userRepository;
		
		// Get All User From DB
		public List<UserEntity> getUsers() {
			
			List<UserEntity> userEntity = userRepository.findAll();
			
			return userEntity;
		}
		
		// Set User in DB
		public UserEntity addUser(Dto userDto) {
			UserEntity userEntity = new UserEntity();
			userEntity.setFirstname(userDto.getFirstname());
			userEntity.setLastname(userDto.getLastname());
			userEntity.setAddress(userDto.getAddress());
			
			userRepository.save(userEntity);
			
			return userEntity;
		}
		
		// Get user using Firstname
		public List<UserEntity> getUserById(String firstname) {
			return userRepository.findByfirstname(firstname);
		}
		
		// Delete User using ID
		public void deleteUser(int id) {
			if(userRepository.existsById(id)) {
				userRepository.deleteById(id);
			}
		}
		
}
