package com.macquarie.niks.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.macquarie.niks.util.InterestRateCalculatorUtil;

@SpringBootTest
public class InterestRateCalculatorUtilTest {

	private InterestRateCalculatorUtil interestRateCalculatorUtil = new InterestRateCalculatorUtil();
	
	@Test
	public void validAccountDetails() {
		
		String bsb = "182182";
		String identification = "111222333";
		
		boolean result = interestRateCalculatorUtil.validateAccountDetails(bsb, identification);
		
		assertEquals(true, result);
	}
	
	@Test
	public void inValidAccountDetails() {
		
		String bsb = "182181";
		String identification = "111222343";
		
		boolean result = interestRateCalculatorUtil.validateAccountDetails(bsb, identification);
		
		assertEquals(false, result);
	}
}
