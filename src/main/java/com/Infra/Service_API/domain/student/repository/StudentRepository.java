package com.Infra.Service_API.domain.student.repository;

import com.Infra.Service_API.domain.student.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student save(Student student);

    Optional<Student> findById(Integer studentId);
}
