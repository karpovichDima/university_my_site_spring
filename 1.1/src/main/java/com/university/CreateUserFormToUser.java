package com.university;



public class CreateUserFormToUser
{
    public static User convert(CreateUserForm userForm){
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setName(userForm.getName());

        return user;
    }
}
