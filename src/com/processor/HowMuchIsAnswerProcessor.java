package com.processor;

import java.util.List;
import java.util.Optional;

import com.exception.InvalidRomanNumberException;
import com.model.Converter;
import com.model.GalaxCoin;
import com.model.GlobalStorage;
import com.utils.PrinterUtils;

public class HowMuchIsAnswerProcessor implements AnswerProcessor {

	private static final String HOW_MUCH_IS_REGEX = "how much is";

	@Override
	public void process(String input, GlobalStorage globalStorage) {
		final List<GalaxCoin> galaxCoins = globalStorage.getGalaxCoinProcessor().getGalaxCoins();
		final String answer = this.getAnswer(input, HOW_MUCH_IS_REGEX);
		final String[] split = answer.split(" ");

		String mountedString = "";

		for (final String selected : split) {
			final Optional<GalaxCoin> found = galaxCoins.stream().filter(s -> s.getName().contains(selected)).findAny();

			if (!found.isPresent()) {
				mountedString = null;
				break;
			}

			mountedString += found.get().getRomanNumber();
		}

		if (mountedString != null) {
			try {
				final Integer converted = new Converter().convert(mountedString);
				System.out.println(answer + " is " + converted);
			} catch (final InvalidRomanNumberException e) {
				PrinterUtils.printErrDefault();
			}
		} else {
			PrinterUtils.printErrDefault();
		}
	}
}
