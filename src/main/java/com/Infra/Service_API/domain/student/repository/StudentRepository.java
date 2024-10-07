package com.Infra.Service_API.domain.student.repository;

import com.Infra.Service_API.domain.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository{

    private final List<Student> students = new ArrayList<>();

    Student save(Student student)
    {
        students.add(student);
        return student;
    };

    public Optional<Student> findById(Integer studentId)
    {
        return students.stream().filter(student -> student.getId().equals(studentId)).findFirst();
    }
}
