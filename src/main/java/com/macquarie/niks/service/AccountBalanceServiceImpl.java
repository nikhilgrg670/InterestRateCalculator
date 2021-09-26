package com.macquarie.niks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.macquarie.niks.model.AccountBalanceDailyDetails;
import com.macquarie.niks.model.AccountBalanceMonthlyDetails;
import com.macquarie.niks.repo.AccountBalanceDailyDetailsRepository;

import reactor.core.publisher.Flux;

public class AccountBalanceServiceImpl implements AccountBalanceService{
	
	@Autowired
	AccountBalanceDailyDetailsRepository interestRateCalculatorRepo;

	@Override
	public void create(List<AccountBalanceDailyDetails> dailyAccountDetailsList) {
		interestRateCalculatorRepo.saveAll(dailyAccountDetailsList).subscribe();
	}

	@Override
	public Flux<AccountBalanceMonthlyDetails> getAccountMonthlyDetails(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(AccountBalanceDailyDetails dailyAccountDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountBalanceDailyDetails dailyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<AccountBalanceDailyDetails> getAccountDailyDetails(String id, String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<AccountBalanceDailyDetails> getAccountDailyDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDailyAccounts(List<AccountBalanceDailyDetails> dailyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMothlyAccounts(List<AccountBalanceMonthlyDetails> monthlyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountBalanceMonthlyDetails dailyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountDailyStatus(AccountBalanceDailyDetails dailyAccountDetailsList, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountMonthlyStatus(AccountBalanceMonthlyDetails monthlyAccountDetailsList, String status) {
		// TODO Auto-generated method stub
		
	}

}
