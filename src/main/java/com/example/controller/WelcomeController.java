package com.example.controller;

import com.example.bean.Welcome;


import com.example.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller

public class WelcomeController {
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);


    private static final String welcomemsg = "Welcome Mr. %s!";

    @PostAuthorize("hasPermission(returnObject, 'read')")
    @RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")

    @ResponseBody
  //  @PreAuthorize("hasPermission('ROLE_WRITE')")
    public Welcome welcomeUser(@RequestParam(name="name", required=false, defaultValue="Java Fan") String name) {

        return new Welcome(String.format(welcomemsg, name));

    }

}