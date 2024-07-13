package com.example.demo.services;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer createItem(Customer customer) { 
		customer.setId(UUID.randomUUID().toString());
		customerRepository.save(customer);
		return customer;
	}

	// update 
	public Customer updateItem(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	// delete
	public Customer deleteItem(String id) {
		customerRepository.findById(id).get();
		Customer customer = customerRepository.findById(id).get();
		customerRepository.delete(customer);
		return customer;
	}
	
}
