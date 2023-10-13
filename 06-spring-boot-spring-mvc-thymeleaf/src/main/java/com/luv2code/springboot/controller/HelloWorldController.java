package com.luv2code.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm() {
        return "hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hello-world";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();

        String result = "Yo! " + theName;
        model.addAttribute("message", result);

        return "hello-world";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model) {
        theName = theName.toUpperCase();

        String result = "Hey my friend " + theName;
        model.addAttribute("message", result);

        return "hello-world";
    }
}