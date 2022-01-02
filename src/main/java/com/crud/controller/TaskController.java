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

import com.crud.model.Task;
import com.crud.service.TaskService;

/**
 * Controlador de la clase Task que permite acceder a los endpoints de la API REST
 * 
 * @author JHONNY
 *
 */
@RestController
@RequestMapping("/tareas")
public class TaskController {
	@Autowired
    TaskService taskService;

    /**
     * Metodo que permite listar todas las tareas
     * @return Lista de todas las tareas
     */
    @GetMapping("/consultar")
    public List<Task> list() {
        return taskService.listAllTask();
    }

    /**
     * Metodo que permite consultar una tarea por identificador
     * @param id identificador de la tarea
     * @return Objeto con la tarea encontrada
     */
    @GetMapping("/consultar/{id}")
    public ResponseEntity<Task> get(@PathVariable Integer id) {
        try {
            Task task = taskService.getTask(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Metodo que que permite crear una tarea
     * @param task objeto de la clase Task
     */
    @PostMapping("/crear")
    public void add(@RequestBody Task task) {
    	taskService.saveTask(task);
    }
    
    
    /**
     * Metodo que permite actualizar la informacion de una tarea
     * @param task Objeto de la clase Task
     * @param id identificador de la tarea a actualizar
     * @return objeto con el resultado de la transaccion
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable Integer id) {
        try {
            Task existTask = taskService.getTask(id);
            task.setId(id);
            taskService.saveTask(task);
            return new ResponseEntity<Task>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Metodo que permite eliminar una tarea
     * @param id identificador de la tarea a eliminar
     */
    @DeleteMapping("borrar/{id}")
    public void delete(@PathVariable Integer id) {
    	taskService.deleteTask(id);
    }
}
