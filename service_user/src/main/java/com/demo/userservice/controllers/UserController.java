package com.demo.userservice.controllers;

import com.demo.userservice.models.User;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping("/{username}")
  public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
    User user = User.builder()
        .id(UUID.randomUUID().toString())
        .username(username)
        .name("Jon Doe")
        .build();

    return ResponseEntity.ok(user);
  }
}
