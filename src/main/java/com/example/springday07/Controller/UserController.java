package com.example.springday07.Controller;

import com.example.springday07.Model.User;
import com.example.springday07.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userSystem")
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;

    //display
    @GetMapping("/display")
    public ResponseEntity getUser(){
        List<User> users = userService.getUser();
        return ResponseEntity.status(200).body(users);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, Errors error, @PathVariable Integer id){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        boolean isValid = userService.updateUser(id,user);
        if(isValid){
            return ResponseEntity.status(200).body("user is updated ");
        }
        return ResponseEntity.status(400).body("Id is not found");
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isValid = userService.deleteUser(id);
        if(isValid){
            return ResponseEntity.status(200).body("user is deleted ");
        }
        return ResponseEntity.status(400).body("Id is not found");

    }

}

