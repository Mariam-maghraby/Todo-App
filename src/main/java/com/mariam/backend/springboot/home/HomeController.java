package com.mariam.backend.springboot.home;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String greetings(){
        return "welcome to springboot!!";
    }

    @GetMapping(value = "/{name}")
    public String greetingsWithName(@PathVariable String name){
        return "welcome, "+ name + " to springboot!!";
    }
}
