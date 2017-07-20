package com.example.dsns.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("articles")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("list")
    public String form(Model model) {
        Search search = searchService.all();
        model.addAttribute("search", search);
        return "search/list";
    }

}
