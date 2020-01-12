package com.itw.learn.controller;

import com.itw.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public  String getUser(HttpServletRequest request){
        return userService.select().toString();
    }
}
