package com.example.dsns;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

	private PostMapper postMapper;

	public PostRepository(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public Identifier create(Post post) {
		return new Identifier(postMapper.create(post));
	}
}
