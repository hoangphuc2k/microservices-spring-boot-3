package com.demo.authenticationservice.controllers;


import com.demo.authenticationservice.clients.UserClient;
import com.demo.authenticationservice.models.UserResponse;
import com.demo.authenticationservice.services.GrpcClientServiceImpl;
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

  @Autowired
  private GrpcClientServiceImpl grpcClientService;

  @GetMapping("grpc/profile/{username}")
  public ResponseEntity<UserResponse> getUserProfileFromGRPC(@PathVariable("username") String username) {
    return ResponseEntity.ok(grpcClientService.getUserByEmail(username));
  }

  @GetMapping("http/profile/{username}")
  public ResponseEntity<UserResponse> getUserProfileFromHttp(@PathVariable("username") String username) {
    return ResponseEntity.ok(userClient.getUserByUserName(username));
  }
}
