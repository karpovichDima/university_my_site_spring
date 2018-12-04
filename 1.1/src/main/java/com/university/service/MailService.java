package com.university.service;

import com.university.utils.Mail;

import javax.xml.bind.ValidationException;

public interface MailService {

    void sendEmail(Mail mail);

    void emailPreparation(String email, String userName) throws ValidationException;


}
