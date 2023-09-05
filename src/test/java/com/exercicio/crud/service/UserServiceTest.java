package com.exercicio.crud.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.exercicio.crud.model.User;
import com.exercicio.crud.repository.UserRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository repository;

	@Mock
	private Logger logger;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void createUsers() {
		User user = new User(500, "Julia", "julia@gmail.com");
		
		when(repository.save(any(User.class))).thenReturn(user);
		
		assertEquals(user, userService.createUser(user).getBody());
	}
	
	@Test
	public void createUsers_badRequest() {
		User user = new User();
		
		when(repository.save(any(User.class))).thenReturn(user);
				
		assertEquals(0, userService.createUser(user).getBody().getId());
	}
	
	@Test
	public void getListUsers() {
		
		ArrayList<User> usuariosMock = new ArrayList<User>();
		
		usuariosMock.add(new User(1, "joao", "joao@email.com"));
		usuariosMock.add(new User(2, "roberto", "roberto@gmail.com"));
		
		when(repository.findAll()).thenReturn(usuariosMock);
		
		assertEquals(2, userService.getUsers().size());
	}
	
	@Test
	public void getUserById() {
		int id = 500;
		
		when(repository.findById(id)).thenReturn(Optional.of(new User(500, "Julia", "julia@gmail.com")));
		
		assertEquals(500, userService.getUser(id).getBody().getId());
	}
	
	@Test
	public void getUserById_notFound() {
		int id = 500;
		
		when(repository.findById(id)).thenReturn(Optional.of(new User()));
				
		assertEquals(0, userService.getUser(id).getBody().getId());
	}
	
	@Test
	public void updateUser() {		
		User user = new User(500, "Julia", "julia@gmail.com");
		
		userService.updateUser(user.getId(), user);
		verify(repository).findById(user.getId());
	}
	
	@Test
	public void removeUser() {		
		int id = 500;
		
		userService.deleteUser(id);
		verify(repository).findById(id);
	}
}

