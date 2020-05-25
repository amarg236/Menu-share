package com.menushare.menushare.controller;

import com.menushare.menushare.model.User;
import com.menushare.menushare.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/public")
public class WelcomeHome {


    @RequestMapping("home")
    public void home(){
        System.out.println("Welcome To The App");
    }




}
