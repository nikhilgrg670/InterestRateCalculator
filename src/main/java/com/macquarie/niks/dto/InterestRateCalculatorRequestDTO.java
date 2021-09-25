package com.macquarie.niks.dto;

import java.util.List;

public class InterestRateCalculatorRequestDTO {
 
	private String balanceDate;
	private List<AccountBalanceDTO> accountBalanceDetails;
	
	
	public String getBalanceDate() {
		return balanceDate;
	}


	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}


	public List<AccountBalanceDTO> getAccountBalanceDetails() {
		return accountBalanceDetails;
	}


	public void setAccountBalanceDetails(List<AccountBalanceDTO> accountBalanceDetails) {
		this.accountBalanceDetails = accountBalanceDetails;
	}


	@Override
	public String toString() {
		return "InterestRateCalculatorRequestDTO [balanceDate=" + balanceDate + ", accountBalanceDetails="
				+ accountBalanceDetails + "]";
	}
	
	
	
}
