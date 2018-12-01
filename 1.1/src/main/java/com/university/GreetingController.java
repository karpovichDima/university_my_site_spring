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
        return "index";
    }
}
