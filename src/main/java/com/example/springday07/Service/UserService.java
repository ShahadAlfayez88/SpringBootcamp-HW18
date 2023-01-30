package com.example.springday07.Service;

import com.example.springday07.Model.Blog;
import com.example.springday07.Model.User;
import com.example.springday07.Repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;


    //display
    public List<User> getUser(){
        return userRepository.findAll();
    }

    //add
    public void addUser(User user){
        userRepository.save(user);
    }

    // update

    public boolean updateUser(Integer id, User user){
        User oldUser = userRepository.getById(id);

        if(!userRepository.existsById(id)){
            return false;
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        User user = userRepository.getById(id);
        if(!userRepository.existsById(id)){
            return false;
        }
        userRepository.delete(user);
        return true;
    }}


