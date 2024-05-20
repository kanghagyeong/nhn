package com.nhnacademy.student.exception;


public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String id) { super(String.format("Student with id '%s' already exists", id)); }

}
