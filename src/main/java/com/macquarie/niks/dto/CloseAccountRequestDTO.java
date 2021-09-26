package com.macquarie.niks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CloseAccountRequestDTO {
	
	private String bsb;
	private String identification;
	
}
