package com.macquarie.niks.service;

import java.util.List;

import com.macquarie.niks.model.AccountBalanceDailyDetails;
import com.macquarie.niks.model.AccountBalanceMonthlyDetails;

import reactor.core.publisher.Flux;

public interface AccountBalanceService {
	
	
	public void create(List<AccountBalanceDailyDetails> dailyAccountDetailsList);
	
	public void updateDailyAccounts(List<AccountBalanceDailyDetails> dailyAccountDetailsList);
	
	public void updateMothlyAccounts(List<AccountBalanceMonthlyDetails> monthlyAccountDetailsList);

	public Flux<AccountBalanceMonthlyDetails> getAccountMonthlyDetails(String month);
	
	public void create(AccountBalanceDailyDetails dailyAccountDetails);
	
	public void update(AccountBalanceDailyDetails dailyAccountDetailsList);
	
	public void update(AccountBalanceMonthlyDetails dailyAccountDetailsList);
	
	public void updateAccountDailyStatus(AccountBalanceDailyDetails dailyAccountDetailsList, String status);
	
	public void updateAccountMonthlyStatus(AccountBalanceMonthlyDetails monthlyAccountDetailsList, String status);
	
	public Flux<AccountBalanceDailyDetails> getAccountDailyDetails(String id, String month);
	
	public Flux<AccountBalanceDailyDetails> getAccountDailyDetails(String id);
	
}
