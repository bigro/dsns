package com.example.dsns;

import javafx.geometry.Pos;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

	private PostMapper postMapper;

	public PostRepository(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public Identifier create(Post post) {
		return postMapper.create(post);
	}
}
