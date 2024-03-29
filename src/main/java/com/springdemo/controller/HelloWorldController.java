package com.springdemo.controller;

import com.springdemo.model.User;
import org.springframework.web.bind.annotation.*;

import java.net.FileNameMap;

@RestController
@RequestMapping("/hello")
public class HelloWorldController
{
    @RequestMapping(value = {"", "/", "home"})
    public String sayHello()
    {
        return "Hello World !!!!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "Fname") String Fname,@RequestParam(value = "Lname") String Lname)
    {
        return "Hello "+ Fname +" "+ Lname+"!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name)
    {
        return  "Hello " + name + "!";
    }
    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " !";
    }


    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + " !";
    }
}
