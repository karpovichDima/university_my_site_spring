package com.university.service.Impl;

import com.university.dao.UserRepository;
import com.university.model.CreateUserForm;
import com.university.model.User;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private User convertFormToUser(CreateUserForm userForm){
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setName(userForm.getName());
        return user;
    }

    @Override
    public HashMap saveUserToDB(CreateUserForm userForm, Model model) {
        HashMap<String, String> listOfAttributes = new HashMap<>();
        User user = convertFormToUser(userForm);
        listOfAttributes.put("email", user.getEmail());
        listOfAttributes.put("name", user.getName());
        userRepository.saveAndFlush(user);
        return listOfAttributes;
    }

    private void isExistUserInDB(User user) throws Exception {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null) throw new Exception("User with it email exist in system");
    }
}
