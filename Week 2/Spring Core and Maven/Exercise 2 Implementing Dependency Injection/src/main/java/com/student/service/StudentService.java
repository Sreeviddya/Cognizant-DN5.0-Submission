package com.student.service;

import com.student.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void registerStudent() {
        System.out.println("Registering student via service...");
        studentRepository.save();
    }
}
