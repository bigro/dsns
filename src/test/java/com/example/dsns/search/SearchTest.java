package com.example.dsns.search;

import com.example.dsns.article.ArticleSearch;
import com.example.dsns.article.Articles;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private ArticleSearch sut;
    private Articles articles;

    @Before
    public void setUp() throws Exception {
        articles = new Articles(Collections.emptyList());
        sut = new ArticleSearch(articles);
    }

    @Test
    public void 記事の一覧を取得できる() throws Exception {
        Articles actual = sut.getArticles();
        assertThat(actual).isEqualTo(articles);
    }
}