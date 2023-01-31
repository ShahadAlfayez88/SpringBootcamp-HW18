package com.example.springday07.Service;

import com.example.springday07.Ecxeption.ApiException;
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
        // method 1
        Blog oldBold = blogrepository.findBlogById(id);

        if(oldBold==null){
            throw new ApiException("Id is not found");
        }
       oldBold.setTitle(blog.getTitle());
       oldBold.setBody(blog.getBody());
       blogrepository.save(oldBold);
       return true;
    }

    // search by title

    public Blog findBlogByTitle(String title){
        Blog blog = blogrepository.findBlogByTitle(title);
        if (blog==null){
            throw new ApiException("title is not found");
        }
        return blog;
    }


    public boolean deletBlog(Integer id){
        // method 2
        Blog oldBold = blogrepository.findIdfrome(id);
        if(!blogrepository.existsById(id)){
            throw new ApiException("Id is not found");
        }
        blogrepository.delete(oldBold);
        return true;
    }}
