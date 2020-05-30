package com.springtest.demospringproject.repository;

import com.springtest.demospringproject.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
