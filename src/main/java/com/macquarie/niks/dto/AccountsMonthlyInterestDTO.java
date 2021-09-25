package com.macquarie.niks.dto;

public class AccountsMonthlyInterestDTO {
	
	
	private String bsb;
	private String identification;
	private String month;
	private String interestAccrued;
	
	
	public String getBsb() {
		return bsb;
	}
	public void setBsb(String bsb) {
		this.bsb = bsb;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getInterestAccrued() {
		return interestAccrued;
	}
	public void setInterestAccrued(String interestAccrued) {
		this.interestAccrued = interestAccrued;
	}
	
	@Override
	public String toString() {
		return "AccountsMonthlyInterestDTO [bsb=" + bsb + ", identification=" + identification + ", month=" + month
				+ ", interestAccrued=" + interestAccrued + "]";
	}
	
	

}
