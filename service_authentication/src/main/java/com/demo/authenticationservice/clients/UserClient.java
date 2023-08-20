package com.demo.authenticationservice.clients;

import com.demo.authenticationservice.models.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-service")
public interface UserClient {

  @RequestMapping(method = RequestMethod.GET, value = "/users/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
  UserResponse getUserByUserName(@PathVariable("username") String username);
}
