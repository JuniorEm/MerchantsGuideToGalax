package com.chain;

import com.model.GlobalStorage;

public class AffirmativeChain extends AbstractChain {

	private static final String AFFIRMATIVE_VALIDATOR_REGEX = "^\\w+\\s\\w+(\\s\\w+)?\\sis\\s\\d+\\sCredits$";
	
	@Override
	public void process(final String input, final GlobalStorage globalStorage) {
		if (this.isValid(input, AFFIRMATIVE_VALIDATOR_REGEX)) {
			globalStorage.getMetalProcessor().add(input, globalStorage.getGalaxCoinProcessor());
		} else {
			this.abstractChain.process(input, globalStorage);
		}
	}
}
