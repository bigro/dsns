package com.example.dsns;

import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostServiceTest {

	PostService sut;

	@Before
	public void setUp() throws Exception {
		PostRepository mock = mock(PostRepository.class);
		when(mock.insert()).thenReturn(new Identifier("1"));
		sut = new PostService(mock);
	}

	@Test
	public void 記事を投稿できること(){
		Post post = new Post(new Author("ooguro"), new Title("タイトル"), new Contents("電子工作しました"));
		Identifier result = sut.write(post);
		assertThat(result.value).isEqualTo("1");
	}
}
