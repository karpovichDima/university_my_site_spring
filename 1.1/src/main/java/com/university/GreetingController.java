package com.university;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GreetingController {

    @GetMapping("/signup")
    public String getTextFromForm(@ModelAttribute CreateUserForm userForm, Model model) {
        if (userForm.getEmail() == null) userForm.setEmail("default@email.com");
        if (userForm.getName() == null) userForm.setEmail("Anonimous");
        User user = CreateUserFormToUser.convert(userForm);
        String email = user.getEmail();
        String name = user.getName();
        model.addAttribute("email", email);
        model.addAttribute("name", name);
        return "index.html";
    }

    @GetMapping("/home")
    public String startMainPage(){
        return "index.html";
    }

    @GetMapping("/contacts")
    public String startContacts(){
        return "contacts.html";
    }

    @GetMapping("/chatauri")
    public String startChatauri(){
        return "chatauri_page.html";
    }

    @GetMapping("/weather")
    public String startWhether(){
        return "sad_weather_page.html";
    }

    @GetMapping("/analiz")
    public String startAnalizPage(){
        return "analiz_page.html";
    }






}
