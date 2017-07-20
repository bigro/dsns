package com.example.dsns.search;

import com.example.dsns.article.Articles;
import com.example.dsns.post.Posts;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private Search sut;
    private Articles articles;

    @Before
    public void setUp() throws Exception {
        articles = new Articles(Collections.emptyList());
        sut = new Search(articles);
    }

    @Test
    public void 記事の一覧を取得できる() throws Exception {
        Articles actual = sut.getArticles();
        assertThat(actual).isEqualTo(articles);
    }
}