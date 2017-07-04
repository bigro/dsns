package com.example.dsns;

public class Identifier {
	String value;

	public Identifier(String value) {
		this.value = value;
	}

	public Identifier(Long value) {
		this.value = Long.toString(value);
	}
}
