package com.student;

import com.student.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.registerStudent();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
