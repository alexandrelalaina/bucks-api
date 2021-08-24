package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.Login;
import com.bucks.bucksapi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository repository;

    public Login add(Login login){
        login.setId(null);
        return repository.save(login);
    }

}
