package com.Infra.Service_API.domain.student.controller;

import com.Infra.Service_API.domain.student.dto.StudentResponse;
import com.Infra.Service_API.domain.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Student(학생)", description = "Student API")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "학생 정보 조회")
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentResponse> getStudent(
            @PathVariable Integer id) {
        return ResponseEntity.ok().body(studentService.getStudent(id));
    }
}
