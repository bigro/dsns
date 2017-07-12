package com.example.dsns.post;

import com.example.dsns.article.Article;

public class Post {
    Article article;

    public Post(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public static Post createEmpty() {
        return new Post(Article.createEmpty());
    }
}
