package by.sergeybukatyi.monitorsensors.controllers;

import by.sergeybukatyi.monitorsensors.entities.Explorer;
import by.sergeybukatyi.monitorsensors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LoginController {
    UserService userService;

    @Autowired
    LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserDetails login(@RequestBody Explorer user) {
        return userService.loadUserByUsername(user.getUsername());
    }

}
