package com.example.dsns.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleSearch all() {
        return new ArticleSearch(articleRepository.searchAll());
    }

    public Article getBy(Identifier identifier) {
        return articleRepository.getBy(identifier);
    }

    public void delete(Identifier identifier) {
        articleRepository.delete(identifier);
    }
}
