package com.macquarie.niks.dto;

public class AccountDetailsDTO {
 
    long identification;
    String openingDate;
    String bsb;
 
    //Getters and setters
 
	public long getIdentification() {
		return identification;
	}

	public void setIdentification(long identification) {
		this.identification = identification;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getBsb() {
		return bsb;
	}

	public void setBsb(String bsb) {
		this.bsb = bsb;
	}

	@Override
	public String toString() {
		return "AccountDetails [identification=" + identification + ", openingDate=" + openingDate
				+ ", bsb=" + bsb + "]";
	}

	
}
