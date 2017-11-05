package com.processor;

import com.model.GlobalStorage;

public interface AnswerProcessor {

	void process(final String input, final GlobalStorage globalStorage);
	
	default String getAnswer(final String input, final String regex) {
		return input.split(regex)[1].replace("?", "").trim();
	}
}
