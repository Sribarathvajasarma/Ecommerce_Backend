package com.springboot.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springboot.demo.domain.Role;
import com.springboot.demo.domain.User;

public interface UserService {
	User saveUser(User user);
	Role saveRoles(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User>getUsers();
	UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
