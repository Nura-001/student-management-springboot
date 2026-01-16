package com.example.studentweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.studentweb.model.Student;
import com.example.studentweb.service.StudentService;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "student-list";
    }

    @PostMapping("/students")
    public String addStudent(Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/students/update")
    public String updateStudent(Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }
}
