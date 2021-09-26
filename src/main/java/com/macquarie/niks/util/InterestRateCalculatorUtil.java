package com.macquarie.niks.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquarie.niks.dto.AccountDetailsDTO;
import com.macquarie.niks.dto.EntityDTO;
import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;
import com.macquarie.niks.mappers.IRCEntityConverter;
import com.macquarie.niks.model.Entity;
import com.macquarie.niks.repo.AccountBalanceDailyDetailsRepository;
import com.macquarie.niks.service.AccountBalanceDailyService;

@Service
public class InterestRateCalculatorUtil {

	@Autowired
	private AccountBalanceDailyDetailsRepository interestRateCalculatorRepository;

	@Autowired
	private IRCEntityConverter ircEntityConverter;
	
	@Autowired
	private AccountBalanceDailyService accountBalanceDailyService;

	/**
	 * This method will be used to save the daily feed in our couchbase. We are
	 * using reactive coucbhase methods for our purposes. Detail flow of method is
	 * defined in method definition.
	 * 
	 * @param feedDate
	 * @param accountBalanceDTO
	 */
	public void saveDailyFeed(InterestRateCalculatorRequestDTO interestRateCalculatorDTO) {

		/**
		 * Date is converted to localDate after standardizing the input in YYYY-MM-DD
		 * format.
		 * 
		 * In case of any exception, exception will be logged. Also such record will be
		 * saved in separate couchbase document named DailyFeedFailedRecords.
		 */
		try {
			SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("YYYY-MM-DD");
			String feedDate = simpleDateFormatter.format(interestRateCalculatorDTO.getBalanceDate());
			final LocalDate localDate = LocalDate.parse(feedDate);
			this.saveDailyFeed(localDate, interestRateCalculatorDTO.getAccountBalanceDetails());
		} catch (Exception e) {
			// Log the Exception
			// Also such record will be saved in separate couchbase document named
			// DailyFeedFailedRecords.

		}

	}
	
	/**
	 * This method will be used to save the daily feed in our couchbase. We are
	 * using reactive coucbhase methods for our purposes. Detail flow of method is
	 * defined
	 * 
	 * @param feedDate
	 * @param list
	 */
	public void saveDailyFeed(LocalDate feedDate, List<EntityDTO> accountBalanceDTOs) {

		// Step 1: Convert the DTO to Entity
		List<Entity> accountBalanceDailyDetails = ircEntityConverter.convertDTOTOEntity(accountBalanceDTOs);

		/*
		 * Step 2: 
		 * Save the entity in Couchbase.
		 *  
		 * Document ID will be bsb_identification_Year_Month. 
		 * 
		 * Default Initial Status for such document is IN_PROGRESS.
		
		 */

		accountBalanceDailyService.create(accountBalanceDailyDetails);
		
	}
	
	
	/**
	 * This method will be used to do initial level validations like length of
	 * bsb/identification. Any other restrictions can be checked in this method.
	 * TODO: We can move this validation method to a separate project or class if
	 * either there is long list of methods in this class or there are different
	 * kind of validations are needed.
	 * 
	 * @param bsb
	 * @param identification
	 * @returns
	 */
	public boolean validateAccountDetails(String bsb, String identification) {
		//TODO: Logic for validation.
		return true;
	}

	/**
	 * This method will be used to make a REST API Call to our Microservice which
	 * will fetch all the required detail like opening account date etc.
	 * 
	 * TODO: We can use Circuiit Breaking Pattern so as to have Fall back Strategy.
	 * If this API call will be failed, then we will save this failure step in
	 * Separate Couchbase document which will be used by our Error Handling
	 * Framework(I can explain the same during interview)
	 * 
	 * @param bsb
	 * @param identification
	 * @return
	 */
	public AccountDetailsDTO getAccountDetails(String bsb, String identification) {

		// TODO: REST CALL to consume the other API to fetch account details;
		return null;
	}

	/**
	 * Based on the Account Details, we can calculate the interest for an individual
	 * account. We will use BigDecimal as a data type to save interests.
	 * 
	 * @param accountDetailsDTO
	 * @return
	 */
	public String calculateInterest(AccountDetailsDTO accountDetailsDTO, String balance) {

		BigDecimal interestAmount = null;
		// TODO: interestAmount will be calculated on Interest Rate and Balance and will
		// be savedin interestAmount.
		String interestRate = getInterestRates(accountDetailsDTO);
		
		interestAmount = getCalculatedInterest(interestRate,balance);
		return interestAmount.toString();
	}

	private BigDecimal getCalculatedInterest(String interestRate, String balance) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getInterestRates(AccountDetailsDTO accountDetailsDTO) {
		/* TODO Logic to get interest rate based on account details.
		 * These details can be fetched through couchbase by maintaining a separate document for such needs
		 * Also, we can create a generic API to fetch the static or master data. */
		return null;
	}

}
