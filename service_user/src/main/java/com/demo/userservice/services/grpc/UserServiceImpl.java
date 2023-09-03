package com.demo.userservice.services.grpc;

import com.demo.userservice.UserRequest;
import com.demo.userservice.UserResponse;
import com.demo.userservice.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@Log4j2
@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

  @Override
  public void getUserByEmail(UserRequest request, StreamObserver<UserResponse> responseObserver) {
    String email = request.getEmail();
    log.info("Received Message email: {}", email);

    UserResponse userResponse = UserResponse.newBuilder()
        .setId(UUID.randomUUID().toString())
        .setName("Demo")
        .setUsername(email)
        .build();

    responseObserver.onNext(userResponse);
    responseObserver.onCompleted();
  }

}
