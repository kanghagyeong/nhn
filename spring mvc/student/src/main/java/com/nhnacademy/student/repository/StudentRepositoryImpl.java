package com.nhnacademy.student.repository;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.exception.StudentAlreadyExistsException;
import com.nhnacademy.student.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private StudentRepository studentRepository;
    private final Map<String, Student> students = new HashMap<>();


    @Override
    public boolean exists(String id) {
        return students.containsKey(id);
    }

    @Override
    public Student register(String id, String password, String name, String email, int score, String comment) {
        if (exists(id)) {
            throw new StudentAlreadyExistsException(id);
        }
        Student student = Student.createStudent(id, password, name, email, score, comment);
        students.put(id, student);
        return student;
    }

    @Override
    public Student getStudent(String id) {
        if (!exists(id)) {
            throw new StudentNotFoundException(id);
        }
        return students.get(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getStudent(id))
                .map(student -> student.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public void updateStudent(String id, String password, String name, String email, int score, String comment) {
        if (!exists(id)) {
            throw new StudentNotFoundException("Student with id '" + id + "' not found");
        }
        Student student = getStudent(id);

        student.setPassword(password);
        student.setName(name);
        student.setEmail(email);
        student.setScore(score);
        student.setComment(comment);

        students.put(student.getId(), student);
    }



}
