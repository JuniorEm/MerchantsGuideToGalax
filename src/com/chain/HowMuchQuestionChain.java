package com.chain;

import com.model.GlobalStorage;
import com.processor.HowMuchIsAnswerProcessor;

public class HowMuchQuestionChain extends AbstractChain {

	private static final String HOW_MUCH_IS_QUESTION_VALIDATOR_REGEX = "^how\\smuch\\sis\\s[(\\w+\\s)]+?\\?$";
	
	@Override
	public void process(final String input, final GlobalStorage globalStorage) {		
		if (this.isValid(input, HOW_MUCH_IS_QUESTION_VALIDATOR_REGEX)) {
			globalStorage.setAnswerProcessor(new HowMuchIsAnswerProcessor());
			globalStorage.getAnswerProcessor().process(input, globalStorage);
		} else {
			this.abstractChain.process(input, globalStorage);
		}
	}

}
