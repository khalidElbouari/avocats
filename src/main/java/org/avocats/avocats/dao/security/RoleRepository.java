package org.avocats.avocats.dao.security;

//RoleRepository.java

import org.avocats.avocats.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
