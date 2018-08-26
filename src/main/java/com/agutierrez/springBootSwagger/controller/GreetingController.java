package com.agutierrez.springBootSwagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello World";
    }

    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public String methodPostExample(@RequestParam(name = "username", required = true) String username) {
        return "hello " + username;
    }
}
