package com.Infra.Service_API.domain.student.service;

import com.Infra.Service_API.domain.student.dto.StudentResponse;
import com.Infra.Service_API.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponse getStudent(Integer id) {
        return studentRepository.findById(id)
                .map(StudentResponse::from)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
