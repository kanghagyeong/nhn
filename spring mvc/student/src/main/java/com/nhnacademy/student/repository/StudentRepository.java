package com.nhnacademy.student.repository;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.exception.StudentNotFoundException;

public interface StudentRepository {
    boolean exists(String id);

    Student register(String id, String password, String name, String email, int score, String comment);

    Student getStudent(String id);

    boolean matches(String id, String password);

    void updateStudent(String id, String password, String name, String email, int score, String comment);

}
