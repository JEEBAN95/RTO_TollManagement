package com.jk.commons;

import java.security.SecureRandom;

public class VhclRegNum {
	private static SecureRandom rndm1, rndm2;

	public static int getFirstGeneratedNum() {

		rndm1 = new SecureRandom();
		rndm1.setSeed(10000000000L);
		int val = rndm1.nextInt();
		return val;
	}// getFirstGeneratedNum

	public static int getSecondGeneratedNum() {

		rndm2 = new SecureRandom();
		rndm2.setSeed(10000000000L);
		int val = rndm2.nextInt();
		return val;
	}// getSecondGeneratedNum
}// class
