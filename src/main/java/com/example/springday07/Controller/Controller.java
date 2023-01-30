package com.example.springday07.Controller;

import com.example.springday07.Model.Blog;
import com.example.springday07.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class Controller {

    final private BlogService blogservice;


    //display
    @GetMapping("/display")
    public ResponseEntity getBlog(){
        List<Blog> blogs = blogservice.getBlog();
        return ResponseEntity.status(200).body(blogs);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        blogservice.addBlog(blog);
        return ResponseEntity.status(200).body("Blog Added");
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog, Errors error, @PathVariable Integer id){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        boolean isValid = blogservice.updateBlog(id,blog);
        if(isValid){
            return ResponseEntity.status(200).body("Blog is updated ");
        }
        return ResponseEntity.status(400).body("Id is not found");
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id){
        boolean isValid = blogservice.deletBlog(id);
        if(isValid){
            return ResponseEntity.status(200).body("Blog is deleted ");
        }
        return ResponseEntity.status(400).body("Id is not found");

    }

}
