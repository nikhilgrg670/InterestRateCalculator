package com.macquarie.niks.service;

import org.springframework.scheduling.annotation.Scheduled;

public class MonthlyInterestRateCalculatorServiceImpl implements MonthlyInterestRateCalculateService {

	@Override
	@Scheduled(cron = "0 0 1 * * ")
	public void publishMonthlyRate() {
		/**TODO
		 * 
		 */
		
		
	}

}
