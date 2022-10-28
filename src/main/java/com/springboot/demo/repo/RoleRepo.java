package com.springboot.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
