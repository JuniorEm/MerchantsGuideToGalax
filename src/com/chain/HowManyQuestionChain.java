package com.chain;

import com.model.GlobalStorage;
import com.processor.HowManyCreditsIsAnswerProcessor;

public class HowManyQuestionChain extends AbstractChain {

	private static final String HOW_MANY_QUESTION_VALIDATOR_REGEX = "how\\smany\\sCredits\\sis\\s[(\\w+\\s)]+\\?";

	@Override
	public void process(final String input, final GlobalStorage globalStorage) {
		
		if (this.isValid(input, HOW_MANY_QUESTION_VALIDATOR_REGEX)) {
			globalStorage.setAnswerProcessor(new HowManyCreditsIsAnswerProcessor());
			globalStorage.getAnswerProcessor().process(input, globalStorage);
		} else {
			System.out.println("I have no idea what you are talking about");
		}
	}
}
