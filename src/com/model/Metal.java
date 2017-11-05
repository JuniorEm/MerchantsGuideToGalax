package com.model;

import java.math.BigDecimal;

public final class Metal {

	private final String metal;
	private final BigDecimal value;
	
	public Metal(final String metal, final BigDecimal value) {
		this.metal = metal;
		this.value = value;
	}

	public String getMetal() {
		return metal;
	}

	public BigDecimal getValue() {
		return value;
	}
}
