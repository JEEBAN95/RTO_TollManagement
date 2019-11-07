package com.jk.commons;

import java.security.SecureRandom;

public class VhclRegNum {
	private static SecureRandom rndm1, rndm2;
	
	public static int getFirstGeneratedNum() {

		rndm1 = new SecureRandom();
		long seed = 10000000;
		rndm1.setSeed(seed);
		int val = rndm1.nextInt();
		return val;
	}// getFirstGeneratedNum

	public static int getSecondGeneratedNum() {

		rndm2 = new SecureRandom();
		long seed = 10000000;
		rndm2.setSeed(seed);
		int val = rndm2.nextInt();
		return val;
	}// getSecondGeneratedNum
}// class
