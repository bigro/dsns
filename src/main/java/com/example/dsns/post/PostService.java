package com.example.dsns.post;

import com.example.dsns.article.ArticleRepository;
import com.example.dsns.article.Identifier;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	private ArticleRepository articleRepository;

	public PostService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public Identifier post(Post post) {
		return articleRepository.create(post.article);
	}
}
