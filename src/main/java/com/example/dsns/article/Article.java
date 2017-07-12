package com.example.dsns.article;

import com.example.dsns.author.Author;

public class Article {
    private Identifier identifier;
    private Author author;
    private Title title;
    private Contents contents;

    public Article(Author author, Title title, Contents contents) {
        new Article(new Identifier(0L), author,title, contents);
    }

    private Article(Identifier identifier, Author author, Title title, Contents contents) {
        this.identifier = identifier;
        this.author = author;
        this.title = title;
        this.contents = contents;
    }

    public static Article createEmpty() {
        return new Article(new Identifier(0L), new Author(""), new Title(""), new Contents(""));
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
