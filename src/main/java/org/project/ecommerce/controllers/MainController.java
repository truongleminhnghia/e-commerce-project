package org.project.ecommerce.controllers;

import org.project.ecommerce.dtos.requests.LoginRequest;
import org.project.ecommerce.dtos.requests.UserRegisterRequest;
import org.project.ecommerce.entities.User;
import org.project.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/e-commerce/api/v1")
@CrossOrigin("/**")
public class MainController {
    @Autowired private UserService userService;

    @PostMapping("/auth/register")
    ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest request) {
        try {
            User user = userService.save(request);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PostMapping("/auth/login")
//    ResponseEntity<?> login(@RequestBody LoginRequest request) {
//
//    }
}
