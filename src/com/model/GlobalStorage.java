package com.model;

import com.processor.AnswerProcessor;
import com.processor.GalaxCoinProcessor;
import com.processor.MetalProcessor;

public class GlobalStorage {

	private final GalaxCoinProcessor galaxDistribution;
	private final MetalProcessor metalProcessor;
	private AnswerProcessor answerProcessor;
	
	public GlobalStorage() {
		this.galaxDistribution = new GalaxCoinProcessor();
		this.metalProcessor = new MetalProcessor();
	}
	
	public GalaxCoinProcessor getGalaxCoinProcessor() {
		return this.galaxDistribution;
	}
	
	public MetalProcessor getMetalProcessor() {
		return this.metalProcessor;
	}
	
	public AnswerProcessor getAnswerProcessor() {
		return this.answerProcessor;
	}
	
	public void setAnswerProcessor(final AnswerProcessor answerProcessor) {
		this.answerProcessor = answerProcessor;
	}
}
