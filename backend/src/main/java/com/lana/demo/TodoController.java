package com.lana.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @GetMapping("/") // ovim kreiramo endpoint na adresi "/"
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/tasks") // ovim kreiramo endpoint na adresi "/tasks"
    public String GetAllTasks() {
                
        return "1. Pokupi smece\n2. Izbaci smece";
    }


}
