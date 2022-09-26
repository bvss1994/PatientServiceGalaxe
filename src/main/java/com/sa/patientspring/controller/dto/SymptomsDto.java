package com.sa.patientspring.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  
@NoArgsConstructor
public class SymptomsDto {
	
	private String sympName;
	private long sympReadings;
	

}
