package com.example.springday07.Controller;

import com.example.springday07.Model.Blog;
import com.example.springday07.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blogservice.addBlog(blog);
        return ResponseEntity.status(200).body("Blog Added");
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog, @PathVariable Integer id) {

        boolean isValid = blogservice.updateBlog(id, blog);

        return ResponseEntity.status(200).body("Blog is updated ");
    }


    //search - by title
    @GetMapping("/getBlog/{title}")
    public ResponseEntity getByTitle(@PathVariable String title ){
        Blog blog = blogservice.findBlogByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }


    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id){

        return ResponseEntity.status(200).body("Blog is deleted ");

    }

}
