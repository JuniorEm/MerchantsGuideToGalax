package com.chain;

public class ChainManager {

	private AbstractChain abstractChain;
	
	public ChainManager() {
		this.abstractChain = new DeclarationChain();
		this.setChain();
	}
	
	public void setChain() {
		final AbstractChain affirmativeChain = new AffirmativeChain();
		final AbstractChain quantityChain = new HowMuchQuestionChain();
		final AbstractChain creditChain = new HowManyQuestionChain();
		
		this.abstractChain.next(affirmativeChain);
		affirmativeChain.next(quantityChain);
		quantityChain.next(creditChain);
	}
	
	public AbstractChain getAbstractChain() {
		return this.abstractChain;
	}
}
