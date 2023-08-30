package com.exercicio.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exercicio.crud.model.User;
import com.exercicio.crud.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	
	UserService(UserRepository userRepository){
		this.repository = userRepository;
	}
	
	public User createUser(User user) {
		return repository.save(user);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public Optional<User> getUser(int id){
		return repository.findById(id);
	}
	
	public Optional<Object> updateUser(int id, User user) {
		return repository.findById(id).map(el -> {
			el.setName(user.getName());
			el.setEmail(user.getEmail());
			
			return repository.save(el);
		});
	}
	
	public ResponseEntity<String> deleteUser(int id){
		if(!repository.findById(id).isEmpty()) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Usuário Deletado");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
} 