package com.crud.repository;

import com.crud.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase que ofrece los metodos necesarios para realizar CRUD sobre la clase Task
 * @author JHONNY
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
