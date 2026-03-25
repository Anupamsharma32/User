package com.ecommerce.user.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
// import com.ecom.ecom_application.dtos.UserRequest;
// import com.ecom.ecom_application.dtos.UserResponse;
// import com.ecom.ecom_application.service.UserService;
import com.ecommerce.user.dto.*;
import com.ecommerce.user.services.*;;;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    

    

    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
    }
    
    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
       
         return userService.fetchUser(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {     // if you will not use getter and setters you will get error becuse it will bind json to user object
        userService.addUser(userRequest);
        return ResponseEntity.ok("user added successfully");
    }

     @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody UserRequest updatedUserRequest) {     // if you will not use getter and setters you will get error becuse it will bind json to user object
       boolean updated= userService.updateUser(id, updatedUserRequest);
        if(updated){ 
            return ResponseEntity.ok("user added successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
