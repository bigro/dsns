package com.example.dsns.article;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {

    private ArticleMapper articleMapper;

    public ArticleRepository(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public Identifier create(Article article) {
        articleMapper.create(article);
        return article.getIdentifier();
    }

    public Articles searchAll() {
        return new Articles(articleMapper.searchAll());
    }

    public Article getBy(Identifier identifier) {
        return articleMapper.getBy(identifier);
    }

    public void delete(Identifier identifier) {
        articleMapper.delete(identifier);
    }
}
