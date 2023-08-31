package com.exercicio.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue
    private int id;
   
    @NotNull
    @Column
    @Size(min = 3, max = 50, message = "Nome deve possuir no mínimo 3 caracteres")
    private String name;
    @NotNull
    @Column
    @Email(message = "Email deve ser válido")
    @Size(min = 10, max = 50, message = "Email deve possuir no mínimo 10 caracteres")
    private String email;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User() {}
	
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}