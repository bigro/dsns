package com.example.dsns.article;

import java.util.Objects;

public class Contents {

	private String value;

	private Contents() {
	}

	public Contents(String value) {
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
