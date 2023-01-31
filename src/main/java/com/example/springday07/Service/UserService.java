package com.example.springday07.Service;

import com.example.springday07.Ecxeption.ApiException;
import com.example.springday07.Model.User;
import com.example.springday07.Repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            throw new ApiException("Id is not found");
        }
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        userRepository.save(oldUser);
        return true;
    }

    // delete

    public boolean deleteUser(Integer id){
        User user = userRepository.getById(id);
        if(!userRepository.existsById(id)){
            throw new ApiException("Id is not found");
        }
        userRepository.delete(user);
        return true;
    }

    // get user by age
    public  List<User> findUserByAge(Integer age){
        List<User> users = userRepository.findUserByAgeGreaterThanEqual(age);
        if (users.isEmpty()){
            throw new ApiException("user is not found");
        }
        return users;
    }

//     get user by role
    public List<User> findByRole(String role){
        List<User> users = userRepository.findAllByRole(role);
        if (users.isEmpty()){
            throw new ApiException("user is not found");
        }
        return users;
    }


    //get user by username and password
    public User findByUsernameAndPassword(String username, String password){
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user==null){
            throw new ApiException("user is not found");
        }
        return user;
    }





    // find by email
    public User findUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        if (user==null){
            throw new ApiException("email is not found");
        }
        return user;
    }




}


