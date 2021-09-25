package com.macquarie.niks.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is an entity for saving monthly interest accrued for a specific account.
 * Primary ID will be combination of identification, bsb, year and Month.
 * 
 * This document will be created only once calculation of all the daily interests is done.
 * 
 * This document will be used by our monthly calculator service to return the monthly interest of a customer.
 * Also this can be used as history for our monthly interest rate certificates
 * @author abc
 *
 */
@Document
public class AccountBalanceMonthlyDetails {
 
    @Id
    long identification;
    String bsb;
    private String year;
    private String month;
    private String monthlyInterestRate; 
 
    //Getters and setters
 

	public long getIdentification() {
		return identification;
	}

	public void setIdentification(long identification) {
		this.identification = identification;
	}

	public String getBsb() {
		return bsb;
	}

	public void setBsb(String bsb) {
		this.bsb = bsb;
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

	public String getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(String monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	@Override
	public String toString() {
		return "AccountBalanceMonthlyDetails [identification=" + identification + ", bsb=" + bsb + ", year=" + year
				+ ", month=" + month + ", monthlyInterestRate=" + monthlyInterestRate + "]";
	}


	
}
