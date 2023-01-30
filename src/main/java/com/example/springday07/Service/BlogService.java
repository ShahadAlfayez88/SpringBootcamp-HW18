package com.example.springday07.Service;

import com.example.springday07.Model.Blog;
import com.example.springday07.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogrepository;

    //display
    public List<Blog> getBlog(){
       return blogrepository.findAll();
    }

    //add
    public void addBlog(Blog blog){
        blogrepository.save(blog);
    }

    // update

    public boolean updateBlog(Integer id, Blog blog){
        Blog oldBold = blogrepository.getById(id);

        if(!blogrepository.existsById(id)){
            return false;
        }
       oldBold.setTitle(blog.getTitle());
       oldBold.setBody(blog.getBody());
       blogrepository.save(oldBold);
       return true;
    }

    public boolean deletBlog(Integer id){
        Blog oldBold = blogrepository.getById(id);
        if(!blogrepository.existsById(id)){
            return false;
        }
        blogrepository.delete(oldBold);
        return true;
    }}
