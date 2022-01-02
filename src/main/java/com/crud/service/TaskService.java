package com.crud.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.model.Task;
import com.crud.repository.TaskRepository;

/**
 * Clase que contiene la logica del negocio. Permite crear una capa entre el repositorio y el controlador 
 * 
 * @author JHONNY
 *
 */
@Service
@Transactional
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	/**
	 * Metodo que permite listar las tareas haciendo uso de la clase JpaRepository
	 * @return Lista de las entidades
	 */
	public List<Task> listAllTask() {
		return taskRepository.findAll();
	}

	/**
	 * Metodo que permite guardar una tarea haciendo uso de la clase JpaRepository
	 * 
	 * @param task Entidad guardada
	 */
	public void saveTask(Task task) {
		taskRepository.save(task);
		taskRepository.flush();
	}

	/**
	 * Metodo que permite consultar una tarea haciendo uso de la clase JpaRepository
	 * 
	 * @param id identificador de la tarea a consultar
	 * @return Entidad encontrada
	 */
	public Task getTask(Integer id) {
		return taskRepository.findById(id).get();
	}

	/**
	 * Metodo que permite eliminar una tarea haciendo uso de la clase JpaRepository
	 * @param id identificador de la tarea a eliminar
	 */
	public void deleteTask(Integer id) {
		taskRepository.deleteById(id);
	}
}
