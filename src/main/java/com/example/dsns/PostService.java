package com.example.dsns;

import org.springframework.stereotype.Service;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService() {
	}

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Identifier write(Post post) {
		return postRepository.create(post);
	}
}
