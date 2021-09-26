package com.macquarie.niks.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
