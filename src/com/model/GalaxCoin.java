package com.model;

public final class GalaxCoin {

	private final  String name;
	private final String romanNumber;
	
	public GalaxCoin(final String name, final String romanNumber) {
		this.name = name;
		this.romanNumber = romanNumber;
	}

	public String getName() {
		return name;
	}

	public String getRomanNumber() {
		return romanNumber;
	}
}
