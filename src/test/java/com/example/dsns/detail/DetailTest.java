package com.example.dsns.detail;

import com.example.dsns.article.Article;
import com.example.dsns.article.Contents;
import com.example.dsns.article.Title;
import com.example.dsns.author.Author;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DetailTest {
    @Test
    public void 記事詳細を取得できること() throws Exception {
        Article article = new Article(new Author("author"), new Title("title"), new Contents("contents"));
        Detail detail = new Detail(article);
        Article actual = detail.getArticle();
        assertThat(actual).isEqualToComparingFieldByField(article);
    }
}
