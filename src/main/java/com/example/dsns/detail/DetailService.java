package com.example.dsns.detail;

import com.example.dsns.article.ArticleRepository;
import com.example.dsns.article.Identifier;

public class DetailService {
    private ArticleRepository articleRepository;

    public DetailService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Detail get(Identifier identifier) {
        return new Detail(articleRepository.get(identifier));
    }
}
