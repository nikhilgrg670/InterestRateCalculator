package com.macquarie.niks.service;

import java.util.List;

import com.macquarie.niks.model.AccountBalanceMonthlyDetails;
import com.macquarie.niks.model.Entity;

import reactor.core.publisher.Flux;

public interface AccountBalanceMonthlyService {
	
	
	public void create(List<Entity> monthlyAccountDetailsList);
	
	public void updateMothlyAccounts(List<Entity> monthlyAccountDetailsList);

	public Flux<AccountBalanceMonthlyDetails> Entity(String month);
	
	public void create(Entity dailyAccountDetails);
	
	public void update(Entity monthlyAccountDetailsList);
	
	public void updateAccountDailyStatus(Entity monthlyAccountDetailsList, String status);
	
	public void updateAccountMonthlyStatus(Entity monthlyAccountDetailsList, String status);
	
	public Flux<List<Entity>> getAccountMonthlyDetails(String id, String month);
	
	public Flux<List<Entity>> getAccountMonthlyDetails(String id);
	
	public Flux<List<Entity>> getAccountMonthlyDetailsPreviousMonth(String month);
	
}
