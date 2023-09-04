package com.exercicio.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({"/users/"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Criação de usuário")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Usuário criado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@ApiOperation(value = "Lista de usuários")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Lista de usuários"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@GetMapping(produces="application/json")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@ApiOperation(value = "Buscar usuário por Id")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Usuário encontrado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@GetMapping(path = {"/{id}"}, produces="application/json")
	public ResponseEntity getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@ApiOperation(value = "Atualização de usuário")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Usuário deletado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@PutMapping(path = {"/{id}"}, produces="application/json", consumes="application/json")
	public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@ApiOperation(value = "Exclusão de usuário")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Usuário deletado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@DeleteMapping(path ={"/{id}"}, produces="application/json")
	public ResponseEntity deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

}