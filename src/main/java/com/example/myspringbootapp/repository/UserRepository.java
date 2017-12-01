package com.example.myspringbootapp.repository;

import com.example.myspringbootapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: liuhao
 * Date: 2017-11-30
 * Time: 15:59
 */
public interface UserRepository extends JpaRepository<User,String>{

}

