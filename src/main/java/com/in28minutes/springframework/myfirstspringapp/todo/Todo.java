package com.in28minutes.springframework.myfirstspringapp.todo;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
@Entity
public class Todo {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Size(min = 10 ,message = "atleast 10 characters")
	private String description;
	private LocalDate date;
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", status="
				+ status + "]";
	}
	public Todo(int id, String name, String description, LocalDate date, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.status = status;
	}
	public Todo() {
			}
	
	
	
	

}
