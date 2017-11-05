package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	private static final String ROMAN_NUMBER_VALIDATOR_REGEX = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	private static final String MANY_DIGITS_VALIDATOR_REGEX = "\\d+";
	private ValidationUtils() {}
	
	public static boolean isMinorThan(final int actualValue, final int newValue) {
		return actualValue < newValue;
	}
	
	public static boolean isMinorThanArraySize(final int index, final int arraySize) {
		return isMinorThan(index, arraySize);
	}
	
	public static boolean isValidRomanNumber(final String romanNumber) {
		return isValidExpression(romanNumber, ROMAN_NUMBER_VALIDATOR_REGEX);
	}
	
	public static boolean isNumeric(final String num) {
		return isValidExpression(num, MANY_DIGITS_VALIDATOR_REGEX);
	}
	
	public static boolean isValidExpression(final String input, final String regex) {
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
