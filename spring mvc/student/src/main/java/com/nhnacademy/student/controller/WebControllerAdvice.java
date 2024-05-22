package com.nhnacademy.student.controller;

import com.nhnacademy.student.exception.StudentAlreadyExistsException;
import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException ex, Model model) {
        log.error("resource not found", ex);
        model.addAttribute("exception", ex);
        model.addAttribute("status", HttpStatus.NOT_FOUND);
        return "error";
    }

    @ExceptionHandler(StudentAlreadyExistsException.class)
    public String handleStudentAlreadyExistsException(StudentAlreadyExistsException ex, Model model) {
        log.error("resource not found", ex);
        model.addAttribute("exception", ex);
        model.addAttribute("status", HttpStatus.BAD_REQUEST);
        return "error";
    }

    @ExceptionHandler(ValidationFailedException.class)
    public String handleValidationFailedException(ValidationFailedException ex, Model model) {
        log.error("validation failed", ex);
        model.addAttribute("exception", ex);
        model.addAttribute("status", HttpStatus.NOT_FOUND);
        return "error";
    }

}
