package com.macquarie.niks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsDTO {
 
    private long identification;
    private String openingDate;
    private String bsb;
 

	@Override
	public String toString() {
		return "AccountDetails [identification=" + identification + ", openingDate=" + openingDate
				+ ", bsb=" + bsb + "]";
	}

	
}
