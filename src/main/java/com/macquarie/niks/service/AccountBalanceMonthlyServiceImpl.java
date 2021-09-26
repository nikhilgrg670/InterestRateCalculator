package com.macquarie.niks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.macquarie.niks.model.AccountBalanceMonthlyDetails;
import com.macquarie.niks.repo.AccountBalanceMonthlyDetailsRepository;

import reactor.core.publisher.Flux;

public class AccountBalanceMonthlyServiceImpl implements AccountBalanceMonthlyService {
	
	@Autowired
	private AccountBalanceMonthlyDetailsRepository accountBalanceMonthlyDetailsRepository;

	@Override
	public void create(List<com.macquarie.niks.model.Entity> monthlyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMothlyAccounts(List<com.macquarie.niks.model.Entity> monthlyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<AccountBalanceMonthlyDetails> Entity(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(com.macquarie.niks.model.Entity dailyAccountDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(com.macquarie.niks.model.Entity monthlyAccountDetailsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountDailyStatus(com.macquarie.niks.model.Entity monthlyAccountDetailsList, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountMonthlyStatus(com.macquarie.niks.model.Entity monthlyAccountDetailsList, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<com.macquarie.niks.model.Entity> getAccountMonthlyDetails(String id, String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<com.macquarie.niks.model.Entity> getAccountMonthlyDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
