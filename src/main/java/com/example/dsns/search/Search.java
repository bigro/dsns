package com.example.dsns.search;

import com.example.dsns.article.Articles;
import com.example.dsns.post.Posts;

public class Search {
    private Articles articles;

    public Search(Articles articles) {
        this.articles = articles;
    }

    public Articles getArticles() {
        return articles;
    }
}
