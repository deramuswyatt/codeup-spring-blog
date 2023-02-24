package com.codeup.codeupspringblog.controllers;

//import com.codeup.codeupspringblog.models.Post;
//import com.codeup.codeupspringblog.repositories.PostRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1,"Wow!", "Free Brownies in the quad!"));
        posts.add(new Post(2,"Uh-oh...", "The brownies betrayed me..."));
//        model.addAttribute("posts", posts);
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsById(@PathVariable long id, Model model) {
        Post post = new Post(id, "Test post", "Why do all these posts look the same?");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsGetCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }
}
