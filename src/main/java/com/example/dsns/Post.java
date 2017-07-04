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

	public static Post createEmpty() {
		return new Post(new Author(""), new Title(""), new Contents(""));
	}

    public Identifier getIdentifier() {
        return identifier;
    }

    public Author getAuthor() {
        return author;
    }

    public Title getTitle() {
        return title;
    }

    public Contents getContents() {
        return contents;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }
}
