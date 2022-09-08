package com.ead.authuser.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ead.authuser.models.UserModel;

public interface UserService {

	List<UserModel> findAll();
	
	Page<UserModel> findAll(Pageable pageable);

	Optional<UserModel> findById(UUID userId);

	void delete(UserModel userModel);

	void save(UserModel userModel);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}