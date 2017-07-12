package com.example.dsns.post;

import com.example.dsns.article.*;
import com.example.dsns.author.Author;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostServiceTest {

	PostService sut;

	@Before
	public void setUp() throws Exception {
		ArticleRepository mock = mock(ArticleRepository.class);
		when(mock.create(any(Article.class))).thenReturn(new Identifier(1L));
		sut = new PostService(mock);
	}

	@Test
	public void 記事を投稿できること(){
		Article article = new Article(new Author("ooguro"), new Title("タイトル"), new Contents("電子工作しました"));
		Identifier result = sut.post(new Post(article));
		assertThat(result.toString()).isEqualTo("1");
	}
}
