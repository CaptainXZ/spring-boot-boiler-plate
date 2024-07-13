package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_items")
public class Item {
	@Id
	private String id;
	@Column(name = "name", nullable = false, length = 50)

	@NotBlank
	private String name;

	@NotBlank
	@Column(name = "category", nullable = false, length = 50)
	private String category;

	// category_id
	@NotBlank
	@Column(name = "category_id")
	private String categoryId;

	@Min(0)
	@Column(name = "qty", nullable = false)
	private int qty;

	@Min(0)
	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "image", nullable = true)
	private String image;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "created_date", nullable = false)
	private String createdDate;

	@Column(name = "status", nullable = false)
	private String status;
}
