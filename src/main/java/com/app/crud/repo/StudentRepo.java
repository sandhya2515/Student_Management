package com.app.crud.repo;


import org.springframework.data.repository.CrudRepository;

import com.app.crud.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long>
{
    
}
