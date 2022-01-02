package com.crud.repository;

import com.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase que ofrece los metodos necesarios para realizar CRUD sobre la clase User
 * @author JHONNY
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
