package com.example.dsns.article;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Identifier {
	Long value;

	private Identifier() {
	}

	public Identifier(Long value) {
		this.value = value;
	}

	public Identifier(String value) {
		this.value = Long.valueOf(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
