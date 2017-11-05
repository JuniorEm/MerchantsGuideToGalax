package com.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.chain.ChainManager;
import com.model.GlobalStorage;

public class Main {
	
	public static void main(String[] args) throws IOException {
		final InputStream is = new FileInputStream("input.txt");
		final InputStreamReader isr = new InputStreamReader(is);
		final BufferedReader br = new BufferedReader(isr);

		final GlobalStorage globalStorage = new GlobalStorage();
		final ChainManager chainManager = new ChainManager();

		while (br.ready()) {
			chainManager.getAbstractChain().process(br.readLine(), globalStorage);
		}

		br.close();
	}
}
