package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Referencua para que es una entidad de la base de datos 
@Table(name= "users")      //Es una entidada y la tabla que genere apartir de esto se llamara users

public class UserModel {
	
	@Id //este es el identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Se genere un identificador
	@Column(nullable = false) //Que esta columna no puede ser nula 
	private long id;
	
	@Column(nullable = false, length=100, name="name")
	private String name;
	
	@Column(nullable = false, length=100)
	private String surname;
	
	@Column(nullable=false, length=100, unique=true)
	private String email;
	
	
	//Getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
