package com.kalcantrell.springbootfirstwebapp.Service;

import com.kalcantrell.springbootfirstwebapp.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUser(String user);
}
