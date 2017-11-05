package com.chain;

import com.model.GlobalStorage;

public class DeclarationChain extends AbstractChain {
	
	private static final String DECLARATION_VALIDATOR_REGEX = "^\\w+\\sis\\s\\w{1}$";
	private static final String IS_SPACE_FILTER_REGEX = "\\sis\\s";
	
	@Override
	public void process(final String input, final GlobalStorage globalStorage) {

		if (this.isValid(input, DECLARATION_VALIDATOR_REGEX)) {
			globalStorage.getGalaxCoinProcessor().add(input, IS_SPACE_FILTER_REGEX);
		} else {
			this.abstractChain.process(input, globalStorage);
		}
	}
}
