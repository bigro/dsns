package com.example.dsns.detail;

import com.example.dsns.article.Identifier;
import com.example.dsns.post.Post;
import com.example.dsns.post.PostService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("{identifier}")
    public String form(Model model, @PathVariable String identifier) {
        Detail detail = detailService.get(new Identifier(identifier));
        model.addAttribute("detail", detail);
        return "detail";
    }

}
