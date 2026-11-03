package com.springboot.sms.service;

import com.springboot.sms.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long id);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudent(Long id);
}
