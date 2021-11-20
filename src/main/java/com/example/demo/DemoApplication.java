package com.example.demo;

import com.example.demo.models.Role;
import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (TaskService taskService, UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_USER"));

			userService.saveUser(new User(null,"Willian Camacho","new-user","13456",new ArrayList<>()));
			userService.saveUser(new User(null,"Willian Camacho","spiderman","13456",new ArrayList<>()));

			userService.addRoleToUser("new-user","ROLE_ADMIN");
			userService.addRoleToUser("spiderman","ROLE_USER");

			taskService.saveTask(new Task(null,"Hacer Tarea 1","Progreso","Baja",null,null));
			taskService.saveTask(new Task(null,"Hacer Tarea 2","Progreso","Media",null,null));
			taskService.saveTask(new Task(null,"Hacer Tarea 3","Progreso","Alta",null,null));
		};
	}
}
