package com.anonymousask.anonymousask.controller;

import com.anonymousask.anonymousask.model.Comment;
import com.anonymousask.anonymousask.model.Post;
import com.anonymousask.anonymousask.service.CommentService;
import com.anonymousask.anonymousask.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PostController {
    private final PostService postService;
    // private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;

    }

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = this.postService.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            Comment comment = new Comment();
            comment.setPost(optionalPost.get());
            model.addAttribute("post", post);
            model.addAttribute("comment", comment);
            return "post";
        } else {
            return "404";
        }
    }

    @GetMapping("/createNewPost")
    public String createNewPost(Model model) {
        return "postForm";
    }

    @PostMapping("/createNewPost")
    public String createNewPost(@Valid @ModelAttribute Post post) {
        this.postService.save(post);
        return "redirect:/post/" + post.getId();
    }

}
