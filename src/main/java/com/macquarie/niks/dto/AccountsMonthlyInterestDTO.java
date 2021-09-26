package com.macquarie.niks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountsMonthlyInterestDTO implements EntityDTO {
	
	
	private String bsb;
	private String identification;
	private String month;
	private String interestAccrued;
	
	
	
	@Override
	public String toString() {
		return "AccountsMonthlyInterestDTO [bsb=" + bsb + ", identification=" + identification + ", month=" + month
				+ ", interestAccrued=" + interestAccrued + "]";
	}
	
	

}
