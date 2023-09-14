package com.exercicio.crud.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exercicio.crud.model.User;
import com.exercicio.crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	private Logger logger = Logger.getLogger("UserService.java");

	public ResponseEntity<User> createUser(User user) {
		try {
 			User usuario = repository.save(user);
			logger.info("Created User - " + usuario.toString());
			return ResponseEntity.ok().body(usuario);
		} catch (Exception e) {
			logger.error("User not created - " +  e.getMessage());
			return ResponseEntity.badRequest().body(new User());
		}
	}

	public List<User> getUsers() {
		List<User> usuarios = repository.findAll();
		logger.info("Get All User - " + usuarios.toString());
		return usuarios;
	}

	public ResponseEntity<User> getUser(int id) {
		return repository.findById(id).map(el -> {
			logger.info("Get User By Id (" + id + ") - " + el.toString());
			return ResponseEntity.ok().body(el);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<User> getUserByEmail(String email) {
		User user = repository.findByEmail(email);
		
		if(!user.equals(null)) {
			 return ResponseEntity.ok().body(user);
		} else {
			 return ResponseEntity.badRequest().build();
		}
	}

	public ResponseEntity<User> updateUser(int id, User user) {
		return repository.findById(id).map(el -> {
			el.setName(user.getName());
			el.setEmail(user.getEmail());

			User updated = repository.save(el);
			logger.info("Updated User (" + id + ") - " + updated.toString());
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<User> deleteUser(int id) {
		return repository.findById(id).map(el -> {
			logger.info("Deleted User (" + id + ") - " + el.toString());
			repository.deleteById(id);
			return ResponseEntity.ok().body(el);
		}).orElse(ResponseEntity.notFound().build());
	}
}