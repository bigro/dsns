package com.example.dsns.author;

import java.util.Objects;

public class Author {

    private String value;

    private Author() {
    }

    public Author(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof String) {
            return Objects.equals(obj, value);
        }
        return false;
    }
}
