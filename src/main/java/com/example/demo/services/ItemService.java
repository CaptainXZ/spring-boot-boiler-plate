package com.example.demo.services;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService{
	@Autowired
	private ItemRepository itemRepository;

	public Item createItem(Item item) { 
		item.setId(UUID.randomUUID().toString());
		item.setCreatedDate(new Date().toString());
		item.setStatus("ACTIVE");
		itemRepository.save(item);
		return item;
	}

	public Iterable<Item> getItems() {
		return itemRepository.findByStatus("ACTIVE");
	}

	public Item updateItem(Item item) {
		itemRepository.save(item);
		return item;
	}

	public Item deleteItem(String id) {
		itemRepository.findById(id).get();
		Optional<Item> item = itemRepository.findById(id);

		if (item.isPresent()) {
			Item itemToDelete = item.get();
			itemToDelete.setStatus("DELETED");
			itemRepository.save(itemToDelete);
			return itemToDelete;
		} else{
			throw new RuntimeException("Item not found");
		}
	}
}
