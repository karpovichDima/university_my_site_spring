package com.university.service;

import com.university.model.CreateUserForm;
import org.springframework.ui.Model;

import java.util.HashMap;

public interface UserService {
    HashMap saveUserToDB(CreateUserForm userForm, Model model);
}
