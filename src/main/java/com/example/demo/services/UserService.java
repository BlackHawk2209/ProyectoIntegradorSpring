package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.models.*;

@Service
public class UserService {
	
	@Autowired //es la creacon del objeto dentro de la inicializacion
	UserRepository userRepository;
	
	public ArrayList<UserModel> getUsers() { //Podemos debolver muchos objetos en array list 
		return (ArrayList<UserModel>) userRepository.findAll();     //este no es un arraylist de user model userRepository.findAll();
	}										//Para evitar problemas hacemos un casteo (ArrayList<UserModel>)


	//Para hacer un usuario, le decimos oslo usemodel porque solo queremos un usuario
	public UserModel saveUser(UserModel user) {
		//Crearemos un validador para que no entren datos vacios
		String name= user.getName();
		String surname = user.getSurname();
		String email= user.getEmail();
		
		if(name!= null && surname!=null && email!=null) { //Si nada de esto es nulo se guarda el usuario 
			return userRepository.save(user);   //Guardara el modelo que le damos y el valor que retorna es el modelo que acaba de guardar
		}
		return user; //Si esta vacio me devuelve el usuario
		//Al hacer esto me regresara un registo con un ID 0 porque no se guardo en  ningun lado porqeu es nulo
	}
	
	public Optional<UserModel> getUserById(Long id) { //Es para evitar que nos falle si no existe el ID --Optinal
		return userRepository.findById(id);
	}

	public boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
	}catch(Exception error){
		return false;
	}}
	
	//Creamos el metodo para debolver un arraylist que se llama getuserbyname 
	public ArrayList<UserModel> getUsersByName(String name){
		return userRepository.findByName(name);
	}
	
}
