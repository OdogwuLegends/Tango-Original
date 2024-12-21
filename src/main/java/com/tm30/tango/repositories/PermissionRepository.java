package com.tm30.tango.repositories;

import com.tm30.tango.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,String> {
    boolean existsByName(String name);
}
