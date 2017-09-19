package com.example.dsns.search;

import com.example.dsns.article.*;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final ArticleRepository articleRepository;

    public SearchService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Search all() {
        return new Search(articleRepository.searchAll());
    }

    public Article getBy(Identifier identifier) {
        return articleRepository.getBy(identifier);
    }
}
