package com.springboot.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.demo.domain.Role;
import com.springboot.demo.domain.User;
import com.springboot.demo.service.UserService;

@SpringBootApplication
public class AuthenticationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationSpringApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args ->{
//			userService.saveRoles(new Role(null, "ROLE_USER"));
//			//userService.saveRoles(new Role(null, "ROLE_MANAGER"));
//			//userService.saveRoles(new Role(null, "ROLE_ADMIN"));
//			//userService.saveRoles(new Role(null, "ROLE_SUPER_ADMIN"));
//			userService.saveRoles(new Role(null, "ROLE_SELLER"));
//
//
//			userService.saveUser(new User(null, "Barath", "barath", "barath", new ArrayList<>()));
//			userService.saveUser(new User(null, "Karan", "karan", "password", new ArrayList<>()));
//			userService.saveUser(new User(null, "Kamal", "kamal", "pass", new ArrayList<>()));
//			userService.saveUser(new User(null, "Kumar", "kumar", "word", new ArrayList<>()));
//
//			userService.addRoleToUser("barath", "ROLE_USER");
//			//userService.addRoleToUser("barath", "ROLE_MANAGER");
//			userService.addRoleToUser("karan", "ROLE_SELLER");
//			
//
//		};
//	}
	

}
