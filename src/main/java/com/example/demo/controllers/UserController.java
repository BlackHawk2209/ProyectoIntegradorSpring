package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;
import com.example.demo.models.*;

@RestController //Respondera atraves de metodos HTTP
@RequestMapping("/user")  //hacer que la ruta iniciale sea esa ("/user")
public class UserController {
//El controlador es lo que se conectara al servicio, que a su ves se conecta con service y con base de datos
	
	@Autowired
	UserService userService;
	
	
	//Para poder acceder por peticiones HTTP le decimos de donde 
	//@RequestMapping(path="/", method= post) si no usamos ese usamoe el de abajo
	@GetMapping // podemos decirle con etse metodo y respondera ala url ya definida aunque solo recibira los del metodo post
	public ArrayList<UserModel> getUsers(){
		return userService.getUsers();  
	}
	
	@PostMapping  //este repondera cuando haga solicitud por post
	public UserModel saveUser(@RequestBody UserModel user) {  //(@RequestBody no saca todo lo del (@RequestBodyy lo asiga a user que es objeto de user model 
		return userService.saveUser(user); 
	}
	
	@GetMapping(path = "/{id}") //Le decimos que debemos recibir un ID del path --Es el metodo para poder regresar un usuario por ID
	public Optional<UserModel> getUserById(@PathVariable("id")Long id){
		return  userService.getUserById(id);
	}
	
	@DeleteMapping(path= "/{id}")  //Va a borrar igual al ID
	public String deleteUser(@PathVariable("id")Long id) {
		boolean ok =  userService.deleteUser(id); //Porque regresara un true o un false desde services
		if(ok == true) {
			return "Se elimino el usuario";
		}else {
			return "No se pudo eliminar el usuario";
		}
	}
	
	// user/query
	@GetMapping(path= "/query")
	public ArrayList<UserModel> getUsersByName(@RequestParam(value = "name", defaultValue="")String name){
		return userService.getUsersByName(name);
	}
}
