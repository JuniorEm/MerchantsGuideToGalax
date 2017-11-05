package com.model;

import java.util.HashMap;
import java.util.Map;

import com.exception.InvalidRomanNumberException;
import com.utils.ValidationUtils;

public class Converter {

	private Map<String, Integer> getRomanNumbersMap() {
		
		final Map<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		
		return map;
	}
	
	public Integer convert(final String romanNumber) {
		
		if (romanNumber == null || romanNumber.equals("")) {
			return null;
		}
		
		final String[] splitted = romanNumber.split("");
		final Map<String, Integer> map = this.getRomanNumbersMap();

		Integer acumulated = 0;
		
		if (ValidationUtils.isValidRomanNumber(romanNumber)) {
			
			for (int i = 0; i < splitted.length; i++) {
				final Integer actual = map.get(splitted[i]);
				
				if (ValidationUtils.isMinorThanArraySize(i + 1, splitted.length) && 
						ValidationUtils.isMinorThan(actual, map.get(splitted[i + 1]))) {
					acumulated = acumulated + (map.get(splitted[i + 1]) - actual);
					i++;
				} else {
					acumulated = acumulated + (actual);
				}
			}
			return acumulated;
		} else {
			throw new InvalidRomanNumberException("The roman number is invalid, please, check out the parameter");
		}
	}
}
