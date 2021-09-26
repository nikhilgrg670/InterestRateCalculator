package com.macquarie.niks.service.manager;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquarie.niks.dto.AccountBalanceDTO;
import com.macquarie.niks.dto.AccountDetailsDTO;
import com.macquarie.niks.dto.AccountsMonthlyInterestDTO;
import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;
import com.macquarie.niks.repo.AccountBalanceDailyDetailsRepository;
import com.macquarie.niks.util.InterestRateCalculatorUtil;

import reactor.core.publisher.Flux;

@Service
public class InterestRateCalculatorServiceManagerImpl implements InterestRateCalculatorServiceManager {

	@Autowired
	InterestRateCalculatorUtil interestRateCalculatorUtil;

	/*
	 * public void create(InterestRateCalculator e) {
	 * InterestRateCalculatorRepo.save(e).subscribe(); }
	 */

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
			/* TODO: 1) Log the expection
			 * 		 2)	Save the invalid data in a couchbase document .*/
		}
	}

	private void processAccountBalanceDetail(AccountBalanceDTO accountBalanceDetail, LocalDate localDate) {
		
		//Step 1: Save the feed
		interestRateCalculatorUtil.saveDailyFeed(localDate, accountBalanceDetail);
		
		//Step 2: Validate the data
		boolean validDetails = interestRateCalculatorUtil.validateAccountDetails(accountBalanceDetail.getBsb(), accountBalanceDetail.getIdentificiation());
		
		if(validDetails) {
			
			//Step 3: Fetch Account Details like opening date etc.
			AccountDetailsDTO accountDetails = interestRateCalculatorUtil.getAccountDetails(accountBalanceDetail.getBsb(), accountBalanceDetail.getIdentificiation());
			
			//Step 4: get Interest amount
			String interestAmount = interestRateCalculatorUtil.calculateInterest(accountDetails);
			
			//Step 5: Update the daily Feed Record with current Interest.
			
			
			

		} else {
			// update the daily Feed Record with validation Error, Change the status to failed. 
		}
				
		

	}

	@Override
	public Flux<AccountsMonthlyInterestDTO> calculateMonthlyInterest(AccountDetailsDTO accountDetailsDTO, String date) {
		
		/*
		 * TODO:
		 *  Data will be fetched from AccountBalanceMonthlyDetails Table using bsb , identification, current Month and Year
		 */
		return null;
		
	}

	/**
	 * This method will be used to fetch the daily interest fetched till now and pubish it before placing
	 * the close account request.
	 * To publish, we can call a REST API which will be responsible for publishing the messages.
	 */
	@Override
	public void closeAccount(String bsb, String identification) {
		
	}

}