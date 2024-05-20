package com.nhnacademy.student.controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentLoginController {
    private final StudentRepository studentRepository;

    public StudentLoginController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "SESSION", required = false) String session, Model model) {
        if (StringUtils.hasText(session)) {
            model.addAttribute("id", session);
            return "redirect:/student/" + session;
        } else {
            return "loginForm";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String password,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (studentRepository.matches(id, password)) {
            HttpSession session = request.getSession(true);
            //session.setAttribute("id", session.getId());

            Cookie cookie = new Cookie("SESSION", id);
            response.addCookie(cookie);

            Student student = studentRepository.getStudent(id);

            modelMap.addAttribute("student", student);
            return  "redirect:/student/" + id;
        } else {
            return "redirect:/student/login";
        }
    }
}
