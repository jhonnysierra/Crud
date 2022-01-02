package com.crud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.User;
import com.crud.service.UserService;

/**
 * Controlador de la clase User que permite acceder a los endpoints de la API REST
 * 
 * @author JHONNY
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	/**
	 * Metodo que permite listar todos los usuarios
	 * 
	 * @return
	 */
	@GetMapping("")
	public List<User> list() {
		return userService.listAllUser();
	}

	/**
	 * Metodo que permite consultar un usuario por identificador
	 * @param id identificador de un usuario
	 * @return Objeto con el usuario encontrado
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable String id) {
		try {
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Metodo que que permite crear un usuario
	 * @param user objeto de la clase User
	 */
	@PostMapping("/")
	public void add(@RequestBody User user) {
		userService.saveUser(user);
	}

	/**
	 * Metodo que permite actualizar la informacion de una tarea
	 * @param user Objeto de la clase User
	 * @param id identificador del usuario a actualizar
	 * @return Objeto con el resultado de la transaccion
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable String id) {
		try {
			User existUser = userService.getUser(id);
			user.setId(id);
			userService.saveUser(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Metodo que permite eliminar un usuario
	 *
	 * @param id identificador del usuario a eliminar
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {

		userService.deleteUser(id);
	}
}
