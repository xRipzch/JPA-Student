package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentRestController {
    StudentRepository studentRepository;

    StudentRestController(StudentRepository studentRepository) {  // constructor injection istead of autowire the field
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> students() {
        var obj = studentRepository.findAll();    // jpa method that finds all students.
        return obj;
    }


    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student std = new Student();
        std.setBornDate(LocalDate.now());
        studentRepository.save(std);
        List<Student> lst = studentRepository.findAll();
        return lst;
    }


    @GetMapping("/students/{name}")
    public List<Student> studentsByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/students/{bornDate}")
        public List<Student> studentsByBornDate (@PathVariable LocalDate bornDate)
        {
            return studentRepository.findByBornDate(bornDate);

        }
    }

