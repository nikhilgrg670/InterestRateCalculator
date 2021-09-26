package com.macquarie.niks.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;
import com.macquarie.niks.service.manager.InterestRateCalculatorServiceManager;
import com.macquarie.niks.util.InterestRateCalculatorUtil;

@Service
public class KafkaService {
	
	@Autowired
	private InterestRateCalculatorUtil interestRateCalculatorUtil;
	
	@Autowired
	private InterestRateCalculatorServiceManager interestRateCalculatorService;
	
	
	public void saveConsumerMessage(String messageObj, String message) {
		
		//TODO: Convert message into InterestRateCalculatorRequestDTO
		InterestRateCalculatorRequestDTO interestRateCalculatorRequestDTO = new 
				InterestRateCalculatorRequestDTO();
		interestRateCalculatorUtil.saveDailyFeed(interestRateCalculatorRequestDTO);
	}


	public void processDailyFeeds(String messageObj, String message) {
		//TODO: Convert message into InterestRateCalculatorRequestDTO
				InterestRateCalculatorRequestDTO interestRateCalculatorRequestDTO = new 
						InterestRateCalculatorRequestDTO();
				
		interestRateCalculatorService.processDailyFeeds(interestRateCalculatorRequestDTO);		
		
	}

}
