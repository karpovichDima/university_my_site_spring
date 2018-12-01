package com.university.service.Impl;

import com.university.dao.UserRepository;
import com.university.model.CreateUserForm;
import com.university.model.User;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.validation.constraints.Null;

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
    public void saveUserToDB(CreateUserForm userForm, Model model) {
        if (userForm.getEmail() == null) {
            model.addAttribute("message", "email is empty");
            return;
        }
        if (userForm.getName() == null) {
            model.addAttribute("message", "name is empty");
            return;
        }
        User user = convertFormToUser(userForm);

        try {
            isExistUserInDB(user);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message","User with it email exist in system");
            return;
        }

        String email = user.getEmail();
        String name = user.getName();

        model.addAttribute("email", email);
        model.addAttribute("name", name);

        userRepository.saveAndFlush(user);
    }

    private void isExistUserInDB(User user) throws Exception {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null) throw new Exception("User with it email exist in system");
    }
}
