package com.processor;

import java.util.ArrayList;
import java.util.List;

import com.model.GalaxCoin;

public class GalaxCoinProcessor {
	
	private List<GalaxCoin> galaxCoins;
	
	public GalaxCoinProcessor() {
		this.galaxCoins = new ArrayList<>();
	}
	
	public void add(final String str, final String regex) {
		final String[] splitted = str.split(regex);
		this.add(new GalaxCoin(splitted[0].trim(), splitted[1].trim()));
	}
	
	private void add(final GalaxCoin galaxCoin) {
		this.galaxCoins.add(galaxCoin);
	}
	
	public List<GalaxCoin> getGalaxCoins() {
		return this.galaxCoins;
	}
	
}
