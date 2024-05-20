package com.nhnacademy.student.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String id) { super(String.format("Student with id '%s' not found", id)); }
}
