package com.nobroker.nobroker.Controller;

import com.nobroker.nobroker.payload.UserDto;
import com.nobroker.nobroker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
        long userId = userService.createUser(userDto);
        return  new ResponseEntity<>("User is created & user id is :"+userId, HttpStatus.CREATED);
    }

}
