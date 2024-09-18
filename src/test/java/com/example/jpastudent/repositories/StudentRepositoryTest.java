package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

   @Autowired
   StudentRepository studentRepository;   // field injection as constructor injection is not possible in test classes

    @Test
    void testOneBruce() {
        List<Student> lst  = studentRepository.findByName("Bruce");
        assertEquals(1, lst.size());
    }



}