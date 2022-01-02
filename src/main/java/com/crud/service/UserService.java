package com.crud.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.model.User;
import com.crud.repository.UserRepository;

/**
 * Clase que contiene la logica del negocio. Permite crear una capa entre el repositorio y el controlador
 * @author JHONNY
 *
 */
@Service
@Transactional
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
    /**
     * Metodo que permite listar los usuarios haciendo uso de la clase JpaRepository
     * @return Lista de las entidades
     */
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    /**
     * Metodo que permite guardar un usuario haciendo uso de la clase JpaRepository
     * @param user Entidad guardada
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Metodo que permite consultar un usuario haciendo uso de la clase JpaRepository
     * @param id identificador de la tarea a consultar
     * @return Entidad encontrada
     */
    public User getUser(String id) {
        return userRepository.findById(id).get();
    }

    /**
     * Metodo que permite eliminar un usuario haciendo uso de la clase JpaRepository
     * @param id identificador del usuario a eliminar
     */
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
