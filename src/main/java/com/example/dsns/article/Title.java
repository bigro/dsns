package com.example.dsns.article;

import java.util.Objects;

public class Title {
	private String value;

	private Title() {
	}

	public Title(String value) {
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
