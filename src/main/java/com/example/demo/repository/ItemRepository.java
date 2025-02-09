package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{
	List<Item> findByStatus(String status);
	Item findByStatusAndName(String status, String name);
}
