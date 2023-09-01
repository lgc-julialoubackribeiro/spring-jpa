package com.exercicio.crud.service;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercicio.crud.model.User;
import com.exercicio.crud.repository.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	
	@Mock
	private UserRepository repository;
	
	@Autowired
	private UserService userService;
	
	private User user = new User(500, "Julia", "julia@gmail.com");
	
	private int id = 600;
	
	@Test
	@Order(1)    
	public void createUsers() {
		//when(repository.save(user)).thenReturn(user);
		assertEquals(200, userService.createUser(user).getStatusCodeValue());
	}
	
	@Test
	public void createUsers_badRequest() {
		User user = new User(500, "Julia", null);
		assertEquals(400, userService.createUser(user).getStatusCodeValue());
	}
	
	@Test
	public void getListUsers() {
		Assertions.assertThat(userService.getUsers().size()).isGreaterThan(0);
	}
	
	@Test
	public void getUserById() {
		assertEquals(200, userService.getUser(user.getId()).getStatusCodeValue());
	}
	
	@Test
	public void getUserById_notFound() {
		assertEquals(404, userService.getUser(id).getStatusCodeValue());
	}
	
	@Test
	public void refreshUser() {		
		user.setName("Clarice");
		user.setEmail("clarice@gmail.com");
		assertEquals(200, userService.updateUser(user.getId(), user).getStatusCodeValue());
	}
	
	@Test
	public void refreshUser_notFound() {		
		assertEquals(404, userService.updateUser(id, user).getStatusCodeValue());
	}
	
	@Test
	public void removeUser() {		
		assertEquals(200, userService.deleteUser(user.getId()).getStatusCodeValue());
	}
	
	@Test
	public void removeUser_notFound() {
		assertEquals(404, userService.deleteUser(id).getStatusCodeValue());
	}
}

