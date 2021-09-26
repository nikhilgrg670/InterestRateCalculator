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
public class InterestRateCalculatorRequestDTO implements EntityDTO{
 
	private String balanceDate;
	private List<EntityDTO> accountBalanceDetails;
	
	
	@Override
	public String toString() {
		return "InterestRateCalculatorRequestDTO [balanceDate=" + balanceDate + ", accountBalanceDetails="
				+ accountBalanceDetails + "]";
	}
	
	
	
}
