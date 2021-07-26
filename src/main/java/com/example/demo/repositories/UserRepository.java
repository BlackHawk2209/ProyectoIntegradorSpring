package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.*;


@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> { //Nos pide 2 cosas modelo al que se concecta y para indicar tipo de dato de ID
	
	public abstract ArrayList<UserModel> findByName(String name); // Buscar usuarios por su nombre
	
}
