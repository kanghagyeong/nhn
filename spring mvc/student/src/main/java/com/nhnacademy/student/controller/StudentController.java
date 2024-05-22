package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.domain.StudentRequest;
import com.nhnacademy.student.exception.ValidationFailedException;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{studentId}")
    public String viewStudent(@PathVariable String studentId, @RequestParam(required = false) String hideScore, Model model) {
        Student student = studentRepository.getStudent(studentId);

        model.addAttribute("student", Student.constructPasswordMaskStudent(student));
        return "studentView";
    }


    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@PathVariable String studentId, Model model) {
        Student student = studentRepository.getStudent(studentId);

        model.addAttribute("student", student);
        return "studentModify";
    }


    @PostMapping("/modify")
    public String modifyStudent( @Valid @ModelAttribute StudentRequest studentRequest,
                                BindingResult bindingResult,
                                Model model) {

        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        studentRepository.updateStudent(studentRequest.getId(),studentRequest.getPassword(),
                studentRequest.getName(),studentRequest.getEmail(),studentRequest.getScore(), studentRequest.getComment());

        Student student = studentRepository.getStudent(studentRequest.getId());
        model.addAttribute("student", student);
        return "redirect:/student/" + student.getId();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String noHandlerFound(NoHandlerFoundException ex, Model model) {
        model.addAttribute("exception", ex);
        model.addAttribute("status", HttpStatus.NOT_FOUND);
        return "error";
    }

}
