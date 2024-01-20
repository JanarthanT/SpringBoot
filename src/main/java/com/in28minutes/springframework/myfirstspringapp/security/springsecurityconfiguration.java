package com.in28minutes.springframework.myfirstspringapp.security;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class springsecurityconfiguration {
	
    
	
	@Bean
	public InMemoryUserDetailsManager createuserdetailsmanager()
	{
		UserDetails createuser1=createuser("Jana","Jana");
		UserDetails createuser2=createuser("Yuvan","Yuvan");
		
		return new InMemoryUserDetailsManager(createuser1,createuser2);
	}
	
	public UserDetails createuser(String username,String password)
	{
		Function<String,String> passwordencoder=input->Passwordencoder().encode(input);
		UserDetails userdetails=User.builder().username(username).password(password).roles("USER","ADMIN").passwordEncoder(passwordencoder).build();
		return userdetails;
	}
	@Bean
	public PasswordEncoder Passwordencoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http)throws Exception
	{
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		}

}
