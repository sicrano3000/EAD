package com.ead.authuser.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ead.authuser.dtos.UserDto;
import com.ead.authuser.dtos.UserDto.UserView;
import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<Object> registerUser(@RequestBody @Validated(UserView.RegistrationPost.class)
											   @JsonView(UserView.RegistrationPost.class) UserDto userDto) {
		log.debug("POST registerUser userDto received {} ", userDto.toString());
		
		if (userService.existsByUsername(userDto.getUsername())) {
			log.warn("Username {} is Already Taken ", userDto.getUsername());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is Already Taken!");
		}
		if (userService.existsByEmail(userDto.getEmail())) {
			log.warn("Email {} is Already Taken ", userDto.getEmail());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email is Already Taken!");
		}
		
		var userModel = new UserModel();
		BeanUtils.copyProperties(userDto, userModel);
		userModel.setUserStatus(UserStatus.ACTIVE);
		userModel.setUserType(UserType.STUDENT);
		userModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
		userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
		
		userService.save(userModel);
		
		log.debug("POST registerUser userId saved {} ", userModel.getUserId());
		log.info("User saved successfully userId {} ", userModel.getUserId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
	}
	
	@GetMapping("/")
	public String index() {
		log.trace("Trace");
		log.debug("Debug");
		log.info("Info");
		log.warn("Warn");
		log.error("Error");
		return "Logging Spring Boot...";
	}

}
