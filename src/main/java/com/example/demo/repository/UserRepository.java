package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	// User findByUsername(String username);
	// User findByEmail(String email);

}
