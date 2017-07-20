package com.example.dsns.article;

public class Identifier {
	Long value;

	private Identifier() {
	}

	public Identifier(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
