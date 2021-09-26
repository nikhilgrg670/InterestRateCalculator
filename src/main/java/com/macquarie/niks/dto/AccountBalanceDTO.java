package com.macquarie.niks.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceDTO implements EntityDTO {
	
	private String bsb;
	private String identificiation;
	private String balance;     //NOTE: We are saving balance in String but we will be using BigDecimal for all our calculations in respective methods
	private String year;
	private String month;
	private String day;
	private BigDecimal interestAccruedToday;
	
	
}
