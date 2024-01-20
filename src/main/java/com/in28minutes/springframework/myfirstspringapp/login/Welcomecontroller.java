package com.in28minutes.springframework.myfirstspringapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springframework.myfirstspringapp.todo.Todo;
import com.in28minutes.springframework.myfirstspringapp.todo.Todoservice;



@Controller
@SessionAttributes("name")
public class Welcomecontroller {
	
	
	
	
	@RequestMapping("/")
	public String welcomepage(ModelMap model)
	{
		
		model.put("name",getusername());
		return "welcome";
	}

	private String getusername()
	{
		String authentication=SecurityContextHolder.getContext().getAuthentication().getName();
		return authentication;	
		}
	
	
}
