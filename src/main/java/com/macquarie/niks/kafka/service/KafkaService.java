package com.macquarie.niks.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;
import com.macquarie.niks.service.manager.InterestRateCalculatorServiceManager;
import com.macquarie.niks.util.InterestRateCalculatorUtil;

/**
 * This class will be responsible for serving the kafka for any purposes. TODO:
 * Need to create an interface for this class so that interface and
 * implementation can be segregated.
 * 
 * @author abc
 *
 */
@Service
public class KafkaService {

	@Autowired
	private InterestRateCalculatorUtil interestRateCalculatorUtil;

	@Autowired
	private InterestRateCalculatorServiceManager interestRateCalculatorService;

	public void saveConsumerMessage(String messageObj, String message) {

		InterestRateCalculatorRequestDTO interestRateCalculatorRequestDTO = getIRCRequestDTO(message, messageObj);
		// daily feed data will be save in bulk to couchbase.
		interestRateCalculatorUtil.saveDailyFeed(interestRateCalculatorRequestDTO);
	}

	public void processDailyFeeds(String messageObj, String message) {

		InterestRateCalculatorRequestDTO interestRateCalculatorRequestDTO = getIRCRequestDTO(message, messageObj);
		interestRateCalculatorService.processDailyFeeds(interestRateCalculatorRequestDTO);

	}

	private InterestRateCalculatorRequestDTO getIRCRequestDTO(String message, String messageObj) {
		/*
		 * TODO Code to write to convert the message and message obj in
		 * InterestRateCalculatorRequestDTO
		 */
		return null;
	}

}
