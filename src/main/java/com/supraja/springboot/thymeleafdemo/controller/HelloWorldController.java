package com.supraja.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // Controller method to show initial form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //Controller to process information
    @GetMapping("/processForm")
    public String processForm () {
        return "helloworld";
    }

    // read form data and add data to model
    @PostMapping("/processFormV2")
    public String letsShout(HttpServletRequest request, Model model) {
        // read parameter from httpServletRequest
        String name = request.getParameter("studentName");

        //convert the data into caps
        name =name.toUpperCase();

        // create the message

        String message = "Yo" + name;

        model.addAttribute("message", message);
        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String letsShout3(@RequestParam("studentName") String theName, Model model) {
        // read parameter using RequestParameter

        //convert the data into caps
        theName =theName.toUpperCase();

        // create the message

        String message = "Yo" + theName;

        model.addAttribute("message", message);
        return "helloworld";
    }
}
