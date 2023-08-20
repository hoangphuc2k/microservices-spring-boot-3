package com.demo.authenticationservice.controllers;


import com.demo.authenticationservice.clients.UserClient;
import com.demo.authenticationservice.models.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

  @Autowired
  private UserClient userClient;

  @GetMapping("/profile/{username}")
  public ResponseEntity<UserResponse> getUserProfile(@PathVariable("username") String username) {
    return ResponseEntity.ok(userClient.getUserByUserName(username));
  }
}
