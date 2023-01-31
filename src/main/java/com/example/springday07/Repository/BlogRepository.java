package com.example.springday07.Repository;

import com.example.springday07.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    // لو ابي استخدم ميثود
    // دايم الدوال تبدأ ب find
    Blog findBlogByTitle(String title);

    Blog findBlogById(Integer id);

    // لو ابي استخدم الكويري ك طريقه بحث
    @Query("select u from Blog  u where  u.id=?1")
    Blog findIdfrome(Integer id);

}
