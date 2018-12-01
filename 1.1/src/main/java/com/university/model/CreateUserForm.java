package com.university.model;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class CreateUserForm implements Serializable {
    @Length(min = 5, max = 500)
    private String name;
    private String email;

    public CreateUserForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}