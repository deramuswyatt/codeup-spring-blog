package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

//    List<Post> all();
//    Long insert(Post post);

//    Ad findAdByTitle(String title);
//    Ad findAdById(long id);
//    Post findAdByTitle(String title);
//    Ad findPostById(long id);
//    @Query("from Ad a where a.title like %:term%")
//    List<Ad> searchByTitleLike(@Param("term") String term);
}
