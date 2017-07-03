package com.example.dsns;

public class Post {
	private Identifier identifier;
	private Author author;
	private Title title;
	private Contents contents;

	public Post(Author author, Title title, Contents contents) {
		this.author = author;
		this.title = title;
		this.contents = contents;
	}
}
