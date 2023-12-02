package com.supraja.springboot.thymeleafdemo.controller;

import com.supraja.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystems}")
    private List<String> operatingSystems;
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        //create a student object
        Student student = new Student();

        //Add as an attribute to student model
        theModel.addAttribute("student", student);

        // Add the list of countries as an attribute
        theModel.addAttribute("countries", countries);

        // Add the list of languages as an attribute
        theModel.addAttribute("languages", languages);

        //Add the list of operating systems
        theModel.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudent (@ModelAttribute("student") Student student) {
        System.out.println("The student " + student);
        return "student-confirmation";
    }
}
