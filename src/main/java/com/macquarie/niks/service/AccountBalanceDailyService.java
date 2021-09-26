package com.macquarie.niks.service;

import java.util.List;

import com.macquarie.niks.dto.EntityDTO;
import com.macquarie.niks.model.AccountBalanceDailyDetails;
import com.macquarie.niks.model.AccountBalanceMonthlyDetails;
import com.macquarie.niks.model.Entity;

import reactor.core.publisher.Flux;

public interface AccountBalanceDailyService {
	
	
	public void create(List<Entity> dailyAccountDetailsList);
	
	public void updateDailyAccounts(List<Entity> dailyAccountDetailsList);
	
	public void updateMothlyAccounts(List<Entity> monthlyAccountDetailsList);

	public Flux<AccountBalanceMonthlyDetails> Entity(String month);
	
	public void create(Entity dailyAccountDetails);
	
	public void updateAccountDailyStatus(Entity dailyAccountDetailsList, String status);
	
	public void updateAccountMonthlyStatus(Entity monthlyAccountDetailsList, String status);
	
	public Flux<Entity> getAccountDailyDetails(String id, String month);
	
	public Flux<Entity> getAccountDailyDetails(String id);

	void update(EntityDTO dailyAccountDetailsList);
	
}
