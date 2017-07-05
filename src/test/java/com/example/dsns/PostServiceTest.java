package com.example.dsns;

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
		PostRepository mock = mock(PostRepository.class);
		when(mock.create(any(Post.class))).thenReturn(new Identifier(1L));
		sut = new PostService(mock);
	}

	@Test
	public void 記事を投稿できること(){
		Post post = new Post(new Author("ooguro"), new Title("タイトル"), new Contents("電子工作しました"));
		Identifier result = sut.write(post);
		assertThat(result.value).isEqualTo(1L);
	}
}
