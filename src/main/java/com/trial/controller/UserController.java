/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trial.controller;

import com.trial.model.User;
import com.trial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author komalkubsad
 */
@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepo;
    
    
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void save (@RequestBody User user){
        userRepo.save(user);
         
    }
    
      @GetMapping("/login")
    @ResponseBody
    public User get (@RequestParam("emailId") String emailId, @RequestParam("password") String password){
         return userRepo.findByEmailIdAndPassword(emailId,password);
    }
    
    
}
