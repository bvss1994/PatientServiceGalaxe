package com.sa.patientspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.patientspring.controller.dto.SymptomsDto;
import com.sa.patientspring.entities.Symptom;

@Mapper
public interface SymptomsMapper {
	
	@Mapping(source = "symptom.sympName", target = "sympName")
	@Mapping(source = "symptom.sympReadings", target = "sympReadings")

	public SymptomsDto convertToDto(Symptom symptom); // Entity to Dto
	
	

}
