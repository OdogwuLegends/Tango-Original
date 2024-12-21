package com.tm30.tango.repositories;

import com.tm30.tango.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
    boolean existsByName(String name);

    Role findByName(String name);
}
