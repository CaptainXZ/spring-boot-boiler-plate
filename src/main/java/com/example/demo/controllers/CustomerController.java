package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/get")
	public ResponseEntity<?> getCustomers() {
		return ResponseEntity.ok(customerService.getCustomers());
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.createItem(customer), HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.updateItem(customer), HttpStatus.CREATED);
	}
	
	// delete
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody String id) {
		return new ResponseEntity<>(customerService.deleteItem(id), HttpStatus.OK);
	}
}
