package com.spring.angular.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.angular.mysql.entity.UserEntity;

import java.util.*;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	List<UserEntity> findByfirstname(String firstname);
	
}
