package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.services.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsIndex(@PathVariable long id, Model model) {
        Post post = postDao.findPostById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsGetCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@RequestParam String title, @RequestParam String body) {
        User user = userDao.findUserById(1);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/save")
    public String savePost(@ModelAttribute Post post) {
        User user = userDao.findUserById(1);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSendPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/create";
    }
}


