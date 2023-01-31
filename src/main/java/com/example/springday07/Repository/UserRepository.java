package com.example.springday07.Repository;

import com.example.springday07.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User>  findUserByAgeGreaterThanEqual(Integer age);

    List<User> findAllByRole(String role);

    User findByEmail(String email);

    User findByUsernameAndPassword(String username, String password);


}
