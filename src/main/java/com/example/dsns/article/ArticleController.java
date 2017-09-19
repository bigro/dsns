package com.example.dsns.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("list")
    public String list(Model model) {
        ArticleSearch articleSearch = articleService.all();
        model.addAttribute("search", articleSearch);
        return "search/list";
    }

    @GetMapping("{articleId}")
    public String detail(@PathVariable("articleId") Identifier identifier, Model model) {
        Article article = articleService.getBy(identifier);
        model.addAttribute("article", article);
        return "search/detail";
    }

    @PostMapping("{articleId}/delete")
    public String delete(@PathVariable("articleId") Identifier identifier) {
        articleService.delete(identifier);
        return "redirect:/articles/list";
    }

}
