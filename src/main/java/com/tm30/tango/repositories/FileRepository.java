package com.tm30.tango.repositories;

import com.tm30.tango.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,String> {
}
