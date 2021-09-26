package com.macquarie.niks.service.manager;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquarie.niks.dto.AccountDetailsDTO;
import com.macquarie.niks.dto.AccountsMonthlyInterestDTO;
import com.macquarie.niks.dto.EntityDTO;
import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;
import com.macquarie.niks.service.AccountBalanceDailyService;
import com.macquarie.niks.service.AccountBalanceMonthlyService;
import com.macquarie.niks.util.InterestRateCalculatorUtil;

import reactor.core.publisher.Flux;

@Service
public class InterestRateCalculatorServiceManagerImpl implements InterestRateCalculatorServiceManager {

	@Autowired
	InterestRateCalculatorUtil interestRateCalculatorUtil;
	
	@Autowired
	AccountBalanceDailyService accountBalanceDailyService;
	
	@Autowired
	AccountBalanceMonthlyService accountBalanceMonthlyService;

	@Override
	public void processDailyFeeds(InterestRateCalculatorRequestDTO interestRateCalculatorDTO) {

		try {
			SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("YYYY-MM-DD");
			String feedDate = simpleDateFormatter.format(interestRateCalculatorDTO.getBalanceDate());
			final LocalDate localDate = LocalDate.parse(feedDate);

			interestRateCalculatorDTO.getAccountBalanceDetails().parallelStream().forEach(accountBalanceDetail -> {
				this.processAccountBalanceDetail(accountBalanceDetail, localDate);
			});

		} catch (Exception exception) {
			/*
			 * TODO: 1) Log the expection 2) Save the invalid data in a couchbase document .
			 */
		}
	}

	private void processAccountBalanceDetail(EntityDTO accountBalanceDetail, LocalDate localDate) {

		// Step 1: Validate the data
		boolean validDetails = interestRateCalculatorUtil.validateAccountDetails(accountBalanceDetail.getBsb(),
				accountBalanceDetail.getIdentificiation());

		if (validDetails) {

			// Step 2: Fetch Account Details like opening date etc.
			AccountDetailsDTO accountDetails = interestRateCalculatorUtil
					.getAccountDetails(accountBalanceDetail.getBsb(), accountBalanceDetail.getIdentificiation());

			// Step 3: get Interest amount
			String interestAmount = interestRateCalculatorUtil.calculateInterest(accountDetails, accountBalanceDetail.getBalance());

			// Step 4: Update the daily Feed Record with current Interest.
			String documentID = getAccountBalanceDailyDetailID(accountBalanceDetail);
			
			accountBalanceDailyService.getAccountDailyDetails(documentID);
			//TODO: Update the status and interestAmount in document fetched in above step.
			
			accountBalanceDailyService.update(accountBalanceDetail);
			
			//This method will accrue the data in AccountBalanceMonthlyDetails table which will contain the interest till now.
			accountBalanceMonthlyService.update(null);
			
			//This will change the status of monthly account data table if local date is last day of month.
			updateAccountMonthlyDetails(accountBalanceDetail, localDate);
			
			
		} else {
			/* Logs the error.*/
			/* update the daily Feed Record with validation Error, Change the status to failed. */
		}

	}

	/**
	 * This method will check if the current local date is last date of month.
	 * If yes, then it will update the status of AccountBalanceMonthly Details.
	 * @param accountBalanceDetail
	 * @param localDate
	 */
	private void updateAccountMonthlyDetails(EntityDTO accountBalanceDetail, LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}

	private String getAccountBalanceDailyDetailID(EntityDTO accountBalanceDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<AccountsMonthlyInterestDTO> calculateMonthlyInterest(AccountDetailsDTO accountDetailsDTO, String date) {

		/*
		 * TODO: Data will be fetched from AccountBalanceMonthlyDetails Table using bsb
		 * , identification, current Month and Year
		 */
		return null;

	}

	/**
	 * This method will be used to fetch the daily interest fetched till now and
	 * pubish it before placing the close account request. To publish, we can call a
	 * REST API which will be responsible for publishing the messages.
	 */
	@Override
	public void closeAccount(String bsb, String identification) {

		/* Step 1: Fetch the Interest accrued till now from document AccountBalanceMonthlyDetails.
		 * 
		 * Step 2: Publish the Interest amount using the Kakfa Producer method.
		 */
	}

}