package com.in28minutes.springframework.myfirstspringapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Todorepository extends JpaRepository<Todo,Integer> {
	
	public List<Todo> findByName(String Name);

}
