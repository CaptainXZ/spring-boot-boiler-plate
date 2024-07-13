package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tbl_customers")
public class Customer {
	@Id
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private int age;
	@NotBlank
	private char gender;
	@NotBlank
	private String email;
	private String phone;
	private String address;
	private String status;
}
