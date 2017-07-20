package com.example.dsns.search;

import com.example.dsns.article.*;
import com.example.dsns.author.Author;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchServiceTest {

    private SearchService searchService;

    @Before
    public void setUp() throws Exception {
        List<Article> articles = Arrays.asList(new Article(new Author("Author1"), new Title("Title1"), new Contents("Contents1")),
                new Article(new Author("Author2"), new Title("Title2"), new Contents("Contents2")));
        ArticleRepository mock = mock(ArticleRepository.class);
        when(mock.searchAll()).thenReturn(new Articles(articles));
        searchService = new SearchService(mock);
    }

    @Test
    public void 全ての記事を検索できる() throws Exception {
        Search search = searchService.all();
        assertThat(search.getArticles().getList())
                .extracting("author", "title", "contents")
                .contains(
                        tuple("Author1","Title1","Contents1"),
                        tuple("Author2","Title2","Contents2")
                );
    }
}