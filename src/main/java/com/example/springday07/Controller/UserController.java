package com.example.springday07.Controller;

import com.example.springday07.Model.User;
import com.example.springday07.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, @PathVariable Integer id){
        boolean isValid = userService.updateUser(id,user);
        return ResponseEntity.status(200).body("user is updated ");

    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isValid = userService.deleteUser(id);
        return ResponseEntity.status(200).body("user is deleted ");

    }

    // find user by age
    @GetMapping("/getUserByAge/{age}")
    public ResponseEntity getByAge(@PathVariable Integer age ){
        List<User> users = userService.findUserByAge(age);
        return ResponseEntity.status(200).body(users);
    }

//     find user by role
    @GetMapping("/getUserByRole/{role}")
    public ResponseEntity getByRole(@PathVariable String role ){
        List<User> users = userService.findByRole(role);
        return ResponseEntity.status(200).body(users);
    }

    //get user by username and password
    @GetMapping("/checkPasswordAndUserName/{username}/{password}")
    public ResponseEntity getByRool(@PathVariable String username, @PathVariable String password){
        User user = userService.findByUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body("user is in the system");
    }

    // get user by email

    @GetMapping("/getUserByemail/{email}")
    public ResponseEntity getByAge(@PathVariable String email ){
        User user = userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

}

