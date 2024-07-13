package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/items")
@Validated
public class ItemController {
	@Autowired 
	private ItemService itemService;

	@GetMapping("/get")
	public ResponseEntity<?> getItems() {
		return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createItem(@Valid @RequestBody Item item) {
		return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateItem(@RequestBody Item item){
		return new ResponseEntity<>(itemService.updateItem(item), HttpStatus.CREATED);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable String id){
		return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);
	}

}
