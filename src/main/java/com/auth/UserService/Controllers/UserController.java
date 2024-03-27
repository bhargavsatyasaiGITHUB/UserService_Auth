package com.auth.UserService.Controllers;

import com.auth.UserService.Services.UserService;
import com.auth.UserService.dtos.LoginRequestDto;
import com.auth.UserService.dtos.SignupRequestDto;
import com.auth.UserService.models.Token;
import com.auth.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody SignupRequestDto requestDto){
        return userService.signUp(requestDto.getEmail(),
                requestDto.getPassword(), requestDto.getName());
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto requestDto){
        return userService.login(requestDto.getEmail(),
                requestDto.getPassword());
    }
    @PostMapping("/logout/{token}")
    public ResponseEntity<Void> logout(@PathVariable("token") String token){
        userService.logout(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("validateToken/{token}")
    public boolean validate(@PathVariable("token") String token){
        return userService.validateToken(token);
    }
}
