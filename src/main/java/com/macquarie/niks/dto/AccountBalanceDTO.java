package com.macquarie.niks.dto;

import java.math.BigDecimal;

public class AccountBalanceDTO {
	
	private String bsb;
	private String identificiation;
	private String balance;     //NOTE: We are saving balance in String but we will be using BigDecimal for all our calculations in respective methods
	private String year;
	private String month;
	private String day;
	private BigDecimal interestAccruedToday;
	
	
	public String getBsb() {
		return bsb;
	}
	public void setBsb(String bsb) {
		this.bsb = bsb;
	}
	public String getIdentificiation() {
		return identificiation;
	}
	public void setIdentificiation(String identificiation) {
		this.identificiation = identificiation;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public BigDecimal getInterestAccruedToday() {
		return interestAccruedToday;
	}
	public void setInterestAccruedToday(BigDecimal interestAccruedToday) {
		this.interestAccruedToday = interestAccruedToday;
	}
	

}
