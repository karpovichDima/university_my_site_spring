package com.university.service;

import com.university.model.CreateUserForm;
import org.springframework.ui.Model;

public interface UserService {
    void saveUserToDB(CreateUserForm userForm, Model model);
}
