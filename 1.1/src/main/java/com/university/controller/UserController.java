package com.university.controller;

import com.university.model.CreateUserForm;
import com.university.model.User;
import com.university.service.Impl.UserServiceImpl;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String getTextFromForm(@ModelAttribute CreateUserForm userForm, Model model) {
        HashMap attributes = userService.saveUserToDB(userForm, model);
        model.addAttribute("email", attributes.get("email"));
        model.addAttribute("name", attributes.get("name"));
        return "indexAfterAuth";
    }

    @GetMapping("/home")
    public String startMainPage() {
        return "index.html";
    }

    @GetMapping("/contacts")
    public String startContacts() {
        return "contacts.html";
    }

    @GetMapping("/chatauri")
    public String startChatauri() {
        return "chatauri_page.html";
    }

    @GetMapping("/weather")
    public String startWhether() {
        return "sad_weather_page.html";
    }

    @GetMapping("/analiz")
    public String startAnalizPage() {
        return "analiz_page.html";
    }

}
