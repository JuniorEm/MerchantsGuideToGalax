package com.chain;

import java.util.regex.Pattern;

import com.model.GlobalStorage;

public abstract class AbstractChain {

	protected AbstractChain abstractChain;
	
	public void next(final AbstractChain abstractChain) {
		this.abstractChain = abstractChain;
	}
	
	public abstract void process(final String input, final GlobalStorage globalStorage);
	
	public boolean isValid(final String input, final String regex) {
		final Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(input).matches();
	}
}
