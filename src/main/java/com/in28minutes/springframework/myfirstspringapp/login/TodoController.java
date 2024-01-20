package com.in28minutes.springframework.myfirstspringapp.login;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springframework.myfirstspringapp.todo.Todo;
import com.in28minutes.springframework.myfirstspringapp.todo.Todorepository;
import com.in28minutes.springframework.myfirstspringapp.todo.Todoservice;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	Todoservice todos;
	
	@Autowired
	Todorepository todorepo;
	
	
	
	@RequestMapping("/todos")
	public String Todos(ModelMap map)
	{
		List<Todo> t=todorepo.findByName(map.getAttribute("name").toString());
		map.put("todos",t);
	
		return "todos";
	}
	

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String addTodos(ModelMap map)
	{
		
		Todo todo=new Todo(0,map.getAttribute("name").toString(),"",LocalDate.now(),false);
		map.put("todo",todo);
		return "add-todo";
	}
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addTodosPost(ModelMap map, @Valid  Todo todo,BindingResult result)
	{
		todorepo.save(todo);
		
		
		return "redirect:todos";
	}
	
	@RequestMapping(value="delete-todo")
	public String deletetodo(@RequestParam int id)
	{
		todorepo.deleteById(id);
		
		return "redirect:todos";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String updatetodo(@RequestParam int id,ModelMap map)
	{
		

		Optional<Todo> todo=todorepo.findById(id);
		map.put("todo",todo);
	
		todorepo.deleteById(id);
		
		
		
		return "add-todo";
	}
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updatetodopost(@Valid  Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "add-todo";
		}
		todorepo.save(todo);
		
		return "redirect:todos";
		}

}
