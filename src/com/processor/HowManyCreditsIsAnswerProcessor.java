package com.processor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.exception.InvalidRomanNumberException;
import com.model.Converter;
import com.model.GalaxCoin;
import com.model.GlobalStorage;
import com.model.Metal;
import com.utils.PrinterUtils;

public class HowManyCreditsIsAnswerProcessor implements AnswerProcessor {

	private static final String HOW_MANY_CREDITS_IS_REGEX = "how many Credits is";

	@Override
	public void process(String input, GlobalStorage globalStorage) {
		final List<GalaxCoin> galaxCoins = globalStorage.getGalaxCoinProcessor().getGalaxCoins();

		final String answer = this.getAnswer(input, HOW_MANY_CREDITS_IS_REGEX);
		final String[] split = answer.split(" ");
		String mountedString = "";

		final List<BigDecimal> metalValues = new ArrayList<>();

		for (final String selected : split) {
			final Optional<GalaxCoin> gc = galaxCoins.stream().filter(s -> s.getName().contains(selected)).findAny();

			if (!gc.isPresent()) {

				final Optional<Metal> metal = globalStorage.getMetalProcessor().getMetals().stream()
						.filter(m -> m.getMetal().equals(selected)).findAny();

				if (!metal.isPresent()) {
					PrinterUtils.printErrDefault();
					return;
				}

				metalValues.add(metal.get().getValue());
			} else {
				mountedString += gc.get().getRomanNumber();
			}
		}

		final BigDecimal metalValue = metalValues.stream().reduce(BigDecimal::multiply).get();

		try {
			Integer convert = Optional.ofNullable(new Converter().convert(mountedString)).orElse(1);

			final BigDecimal result = new BigDecimal(convert).multiply(metalValue);
			System.out.println(answer + " is " + result.toString().replace(".0", ""));
		} catch (final InvalidRomanNumberException e) {
			PrinterUtils.printErrDefault();
		}
	}

}
