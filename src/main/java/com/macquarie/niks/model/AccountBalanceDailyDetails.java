package com.macquarie.niks.model;

public class AccountBalanceDailyDetails {
	
	private String balance;     //NOTE: We are saving balance in String but we will be using BigDecimal for all our calculations in respective methods
	private String year;
	private String month;
	private String day;
	private String interestAccruedToday;
	
	
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
	public String getInterestAccruedToday() {
		return interestAccruedToday;
	}
	public void setInterestAccruedToday(String interestAccruedToday) {
		this.interestAccruedToday = interestAccruedToday;
	}

}
