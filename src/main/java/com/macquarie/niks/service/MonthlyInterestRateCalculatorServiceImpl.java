package com.macquarie.niks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.macquarie.niks.kafka.publisher.KafkaPublisher;

public class MonthlyInterestRateCalculatorServiceImpl implements MonthlyInterestRateCalculateService {
	
	@Autowired
	private AccountBalanceMonthlyService accountBalanceMonthlyService;
	
	@Autowired
	private KafkaPublisher kafkaPublisher;

	@Override
	@Scheduled(cron = "0 0 1 * * ") 
	/**
	 * This scheduled is run at 12:00 AM at every first day of month
	 */
	public void publishMonthlyRate() {
		/**TODO
		 *  Step 1: We will fetch the previous month as we need to fetch interest rates for previous month.
		 *  
		 *  Step 2: It will fetch the details from AccountBalanceMonthlyDetails table which have COMPLETED status
		 *  
		 *  Step 3: It will publish the data using KafkaProducer.
		 */
		
		String previousMonth = getPreviousMonth();
		
		accountBalanceMonthlyService.getAccountMonthlyDetailsPreviousMonth(previousMonth);
		
		String messageObj = getMessageObj();
		String message = getMessage();
		
		kafkaPublisher.publishMessage(messageObj, message);
		
		
	}

	//TODO: this method will fetch the details from accountBalanceMonthlyService and will return required objects.
	private String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getMessageObj() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getPreviousMonth() {
		// TODO Auto-generated method stub
		return null;
	}

}
