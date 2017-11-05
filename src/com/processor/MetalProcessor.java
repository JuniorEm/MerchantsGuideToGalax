package com.processor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import com.model.Converter;
import com.model.GalaxCoin;
import com.model.Metal;
import com.utils.ValidationUtils;

public class MetalProcessor {

	private List<Metal> metals = new ArrayList<>();
	private static final String MANY_CHARACTERS_FILTER_REGEX = "\\w+";
	
	public MetalProcessor() {}
	
	public void add(final String input, final GalaxCoinProcessor galaxDistribution) {
		final String[] obtained = input.split(" ");
		final List<GalaxCoin> collected = new ArrayList<>();
		Integer num = null;
		
		for (final String selected : obtained) {
			
			 Optional<GalaxCoin> galaxCoin = galaxDistribution.getGalaxCoins().stream().filter(gc -> gc.getName().equals(selected)).findAny();
			
			 if (galaxCoin.isPresent()) {
				 collected.add(galaxCoin.get());
			 }
			
			if (ValidationUtils.isNumeric(selected.trim())) {
				num = Integer.parseInt(selected);
			}
		}
		
		final String romanNumber = this.getRomanNumber(collected);
		this.metals.add(new Metal(this.getMetalName(obtained), 
				new BigDecimal(num).divide(new BigDecimal(new Converter().convert(romanNumber)))));
	}
	
	public String getRomanNumber(final List<GalaxCoin> galaxCoins) {
		String value = "";
		
		for (final GalaxCoin galaxCoin : galaxCoins) {
			value += galaxCoin.getRomanNumber();
		}
		
		return value;
	}
	
	public String getMetalName(final String[] array) {
		final String firstPositionWhereMetalCanBe = array[1];
		final String secondPositionWhereMetalCanBe = array[2];
		
		if (Pattern.compile(MANY_CHARACTERS_FILTER_REGEX).matcher(secondPositionWhereMetalCanBe).matches()) {
			return secondPositionWhereMetalCanBe;
		}
		return firstPositionWhereMetalCanBe;
	}
	
	public List<Metal> getMetals() {
		return this.metals;
	}
}
