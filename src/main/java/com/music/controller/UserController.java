package com.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.ResponseObject;
import com.music.model.User;
import com.music.service.impl.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<ResponseObject<User>> login(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.login(user));
  }

}
