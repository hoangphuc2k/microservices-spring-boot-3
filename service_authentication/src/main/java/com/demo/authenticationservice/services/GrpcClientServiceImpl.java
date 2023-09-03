package com.demo.authenticationservice.services;

import com.demo.authenticationservice.models.UserResponse;
import com.demo.userservice.UserRequest;
import com.demo.userservice.UserServiceGrpc.UserServiceBlockingStub;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GrpcClientServiceImpl {

  @GrpcClient("user-service")
  private UserServiceBlockingStub userServiceBlockingStub;

  public UserResponse getUserByEmail(String email) {
    com.demo.userservice.UserResponse userResponseGRPC = userServiceBlockingStub
        .getUserByEmail(UserRequest.newBuilder().setEmail(email).build());

    return UserResponse.builder()
        .id(userResponseGRPC.getId())
        .name(userResponseGRPC.getName())
        .username(userResponseGRPC.getUsername())
        .build();
  }
}
