package com.example.dsns.article;

import java.util.List;

public class Articles {
    private List<Article> list;

    public Articles(List<Article> list) {
        this.list = list;
    }

    public int size() {
        return list.size();
    }

    public List<Article> getList() {
        return list;
    }
}
