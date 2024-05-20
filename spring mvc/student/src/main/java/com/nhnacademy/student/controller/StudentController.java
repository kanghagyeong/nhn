package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        if (student == null) {
            return "error";
        }
        if ("yes".equals(hideScore)) {
            student.setScore(-1);
        }
        model.addAttribute("student", Student.constructPasswordMaskStudent(student));
        return "studentView";
    }


    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@PathVariable String studentId, Model model) {
        Student student = studentRepository.getStudent(studentId);
        if (student == null) {
            return "error";
        }
        model.addAttribute("student", student);
        return "studentModify";
    }


    @PostMapping("/modify")
    public String modifyStudent( @RequestParam("id") String id,
                             @RequestParam("password") String password,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("score") int score,
                             @RequestParam("comment") String comment,
                                Model model) {

        Student student = studentRepository.getStudent(id);
        if (student == null) {
            return "error";
        }

        studentRepository.updateStudent(student,id,password,name,email,score,comment);
       // Student student = studentRepository.register(id, password, name, email, score, comment);
        model.addAttribute("student", student);
        return "redirect:/student/" + id;
    }

}
