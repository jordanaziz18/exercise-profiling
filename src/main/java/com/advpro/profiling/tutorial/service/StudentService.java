package com.advpro.profiling.tutorial.service;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;

/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {

        return studentCourseRepository.findAllWithStudentsAndCourses();
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return 
    Optional.ofNullable(studentRepository.findTopByOrderByGpaDesc());
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
        StringJoiner joiner = new StringJoiner(", ");
        for (Student student : students) {
            joiner.add(student.getName());
        }
        return joiner.toString();
    }
}

