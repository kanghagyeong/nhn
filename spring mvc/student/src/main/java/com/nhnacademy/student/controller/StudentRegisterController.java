package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {
    private final StudentRepository studentRepository;

    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentRegisterForm() {
        return "studentRegister";
    }

    @PostMapping
    public String studentRegister(@RequestParam("id") String id,
                                  @RequestParam("password") String password,
                                  @RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("score") int score,
                                  @RequestParam("comment") String comment,
                                  Model model) {
        Student student = studentRepository.register(id, password, name, email, score, comment);
        model.addAttribute("student", Student.constructPasswordMaskStudent(student));

        ModelAndView mav = new ModelAndView("student");
        mav.addObject("student", Student.constructPasswordMaskStudent(student));
        return "studentView";
    }
}
