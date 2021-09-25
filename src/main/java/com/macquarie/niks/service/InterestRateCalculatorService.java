package com.macquarie.niks.service;


import com.macquarie.niks.dto.AccountDetailsDTO;
import com.macquarie.niks.dto.AccountsMonthlyInterestDTO;
import com.macquarie.niks.dto.InterestRateCalculatorRequestDTO;

import reactor.core.publisher.Flux;
 
public interface InterestRateCalculatorService
{
     
	void processDailyFeeds(InterestRateCalculatorRequestDTO interestRateCalculatorDTO);
	
	Flux<AccountsMonthlyInterestDTO> calculateMonthlyInterest(AccountDetailsDTO accountDetails, String date);
	
	void closeAccount(String bsb, String identification);
 
}