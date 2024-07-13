package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public String createUser() {
		return "create user";
	}
	
	public String updateUser() {
		return "update user";
	}
}
