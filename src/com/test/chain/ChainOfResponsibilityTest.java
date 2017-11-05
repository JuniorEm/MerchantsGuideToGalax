package com.test.chain;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.chain.AbstractChain;
import com.chain.AffirmativeChain;
import com.chain.ChainManager;
import com.chain.DeclarationChain;

public class ChainOfResponsibilityTest {

	private AbstractChain expectedAbstractChainTest;
	private AbstractChain actualAbstractChainTest;
	private AbstractChain expectedDeclarationTest;
	private AbstractChain expectedAffirmationTest;
	private AbstractChain actualDeclarationTest;

	@Before
	public void beforeSetChainTest() {
		this.expectedAbstractChainTest = new DeclarationChain();
		this.actualAbstractChainTest = new ChainManager().getAbstractChain();
	}

	@Test
	public void setAbstractChainTest() throws Exception {
		Assert.assertEquals(this.expectedAbstractChainTest.getClass().getSimpleName(),
				this.actualAbstractChainTest.getClass().getSimpleName());

		final Field expectedField = this.expectedAbstractChainTest.getClass().getDeclaredField("regex");
		final Field actualField = this.actualAbstractChainTest.getClass().getDeclaredField("regex");
		this.setAccessibleTrue(expectedField, actualField);
		
		final String expectedRegex = (String) expectedField.get(this.expectedAbstractChainTest);
		final String actualRegex = (String) actualField.get(this.actualAbstractChainTest);
		
		Assert.assertEquals(expectedRegex, actualRegex);
	}
	
	@Before
	public void beforeNextOfChainTest() {
		this.expectedDeclarationTest = new DeclarationChain();
		this.expectedAffirmationTest = new AffirmativeChain();
		this.actualDeclarationTest = new ChainManager().getAbstractChain();
		
		this.expectedDeclarationTest.next(this.expectedAffirmationTest);
		
	}
	
	@Test
	public void nextOfChainTest() throws Exception {
		final Field expectedAbstract = this.expectedDeclarationTest.getClass().getSuperclass().getDeclaredField("abstractChain");
		final Field actualAbstract = this.actualDeclarationTest.getClass().getSuperclass().getDeclaredField("abstractChain");
		
		this.setAccessibleTrue(expectedAbstract, actualAbstract);
		
		final AffirmativeChain expectedAffirmativeChain = (AffirmativeChain) expectedAbstract.get(this.expectedDeclarationTest);
		final AffirmativeChain actualAffirmativeChain = (AffirmativeChain) actualAbstract.get(this.actualDeclarationTest);
		
		this.expectedAbstractChainTest = expectedAffirmativeChain;
		this.actualAbstractChainTest = actualAffirmativeChain;
		
		this.setAbstractChainTest();
	}
	
	@After
	public void cleanAllFields() {
		final List<Field> asList = Arrays.asList(this.getClass().getDeclaredFields());
		this.setAccessibleTrue(asList);
		asList.stream().forEach(s -> {
			try {
				s.set(this, null);
			} catch (final IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException("Violated access, warning", e);
			}
		});
	}
	
	private void setAccessibleTrue(final Field... fields) {
		this.setAccessibleTrue(Arrays.asList(fields));
	}
	
	private void setAccessibleTrue(final List<Field> fields) {
		fields.forEach(s -> s.setAccessible(true));
	}
}
