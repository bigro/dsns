package com.example.dsns.post;

import com.example.dsns.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @ModelAttribute("post")
    Post post() {
        return new Post(Article.createEmpty());
    }

    @GetMapping("form")
    public String form(){
        return "post/form";
    }

    @PostMapping()
    public String write(@ModelAttribute("post") Post post) {
        postService.post(post);
        return "redirect:/post/form";
    }
}
