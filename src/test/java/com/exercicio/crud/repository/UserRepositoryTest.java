package com.exercicio.crud.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.exercicio.crud.model.User;
import com.exercicio.crud.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	
	@Mock
	private UserService userService;
	
	@Test
	public void createUser() {
		User user = new User();
	}
	
	@Test
	public void dontCreateUser() {
		/*User savedUser = userService.createUser(new User("Teste", null));
		
		Assertions.assertThat(savedUser).isNull();*/
	}
	
	
}