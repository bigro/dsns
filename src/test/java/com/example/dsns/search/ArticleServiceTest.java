package com.example.dsns.search;

import com.example.dsns.TestApplication;
import com.example.dsns.article.*;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    DriverManagerDestination driverManagerDestination;

    static final Operation DELETE_ALL = deleteAllFrom("article");

    @Before
    public void setUp() throws Exception {
        DbSetup dbSetup = new DbSetup(driverManagerDestination, DELETE_ALL);
        dbSetup.launch();
    }

    @Test
    public void 全ての記事を検索できる() throws Exception {
        Operation operation = insertInto("article")
                .columns("author", "title", "contents")
                .values("Author1", "Title1", "Contents1")
                .values("Author2", "Title2", "Contents2")
                .build();
        DbSetup dbSetup = new DbSetup(driverManagerDestination, operation);
        dbSetup.launch();

        ArticleSearch articleSearch = articleService.all();
        assertThat(articleSearch.getArticles().getList())
                .extracting("author", "title", "contents")
                .contains(
                        tuple("Author1", "Title1", "Contents1"),
                        tuple("Author2", "Title2", "Contents2")
                );
    }

    @Test
    public void IDから記事を取得できる() throws Exception {
        Operation operation = insertInto("article")
                .columns("identifier", "author", "title", "contents")
                .values("1", "Author1", "Title1", "Contents1")
                .build();
        DbSetup dbSetup = new DbSetup(driverManagerDestination, operation);
        dbSetup.launch();

        Article actual = articleService.getBy(new Identifier(1L));

        assertThat(actual)
                .extracting("author", "title", "contents")
                .contains("Author1", "Title1", "Contents1");
    }

    @Test
    public void 記事を削除できる() throws Exception {
        Operation operation = insertInto("article")
                .columns("identifier", "author", "title", "contents")
                .values("1", "Author1", "Title1", "Contents1")
                .build();
        DbSetup dbSetup = new DbSetup(driverManagerDestination, operation);
        dbSetup.launch();

        articleService.delete(new Identifier(1L));

        Article actual = articleService.getBy(new Identifier(1L));
        assertThat(actual).isNull();
    }
}