package com.auth.UserService.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
        @PostMapping("/hi")
    public String sayHello(){
            return "Hello World";
        }
}
