package com.macquarie.niks.util;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquarie.niks.dao.InterestRateCalculatorRepository;
import com.macquarie.niks.dto.AccountBalanceDTO;
import com.macquarie.niks.dto.AccountDetailsDTO;

@Service
public class InterestRateCalculatorUtil {
	
	@Autowired
	private InterestRateCalculatorRepository interestRateCalculatorRepository;
	
	/**
	 * This method will be used to do initial level validations like length of bsb/identification.
	 * Any other restrictions can be checked in this method.
	 * TODO: We can move this validation method to a separate project or class if either there is long list of methods in this
	 * class or there are different kind of validations are needed. 
	 * @param bsb
	 * @param identification
	 * @returns
	 */
	public boolean validateAccountDetails(String bsb, String identification) {
		
		return true;
	}
	
	/**
	 * This method will be used to make a REST API Call to our Microservice which will fetch all the required
	 * detail like opening account date etc.
	 * 
	 * TODO: We can use Circuiit Breaking Pattern so as to have Fall back Strategy.
	 * If this API call will be failed, then we will save this failure step in Separate Couchbase document which 
	 * will be used by our Error Handling Framework(I can explain the same during interview)  
	 * @param bsb
	 * @param identification
	 * @return
	 */
	public AccountDetailsDTO getAccountDetails(String bsb, String identification) {
		
		// REST CALL to consume the other API to fetch account details;
		return null;
	}
	
	
	/**
	 * Based on the Account Details, we can calculate the interest for an individual account. 
	 * We will use BigDecimal as a data type to save interests.
	 * @param accountDetailsDTO
	 * @return
	 */
	public String calculateInterest(AccountDetailsDTO accountDetailsDTO) {
		
		BigDecimal interestAmount = null;
		//TODO: interestAmount will be calculated on Interest Rate and Balance and will be savedin interestAmount.
		return null;
	}
	
	/**
	 * This method will be used to save the daily feed in our couchbase. 
	 * We are using reactive coucbhase methods for our purposes.
	 * Detail flow of method is defined 
	 * @param feedDate
	 * @param accountBalanceDTO
	 */
	public void saveDailyFeed(LocalDate feedDate, AccountBalanceDTO accountBalanceDTO) {
		
		//Step 1: Convert the DTO to Entity
		
		/* Step 2: Save the entity in Couchbase. 
		 * 		> Document ID will be bsb_identification_Year_Month.
		 * 		> Default Initial Status for document will be IN_PROGRESS. This will be defined in domain class itself.
		 * 		> If the feed date is last date of Month, We will change the status of document to COMPLETED.
		 * 		This COMPLETED status will be used by our monthly calculator service to pick up all the employee records
		 * 		for which interest rates has been accrued.	 		
		 * 		> All the failures like folliowing one which are temporary in nature will be retried
		 * 			 i) CAS MISMATCH EXCEPTION
		 * 			 ii) Temporary Failure Exception
		 *      > All other failures will be only logged and status of document will be marked as FAILED.     
		 *           
		 *           */
		
	}
	
}
