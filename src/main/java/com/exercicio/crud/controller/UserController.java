package com.exercicio.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.crud.model.User;
import com.exercicio.crud.service.UserService;

@RestController
@RequestMapping({"/users"})
public class UserController {
	
	private UserService userService;
	
	UserController(UserService userService){
		this.userService = userService;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping(path = {"/{id}"})
	public Optional<User> getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public Optional<Object> updateUser(@PathVariable int id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

}