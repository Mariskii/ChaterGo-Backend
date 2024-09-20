package com.vicent.chatergo.Controller;

import com.vicent.chatergo.Implementation.UserServiceImplementation;
import com.vicent.chatergo.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImpl;

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public UserModel addUser(@Payload UserModel user) {
        userServiceImpl.saveUser(user);
        return user;
    }

    public UserModel disconnect(
            @Payload UserModel user
    ) {
        userServiceImpl.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> findConnectedUsers() {
        return ResponseEntity.ok(userServiceImpl.findConnectedUsers());
    }
}
