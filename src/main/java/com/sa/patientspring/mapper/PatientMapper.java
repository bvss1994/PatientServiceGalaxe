package com.sa.patientspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.patientspring.controller.dto.PatientDto;
import com.sa.patientspring.entities.Patient;

@Mapper
public interface PatientMapper {
	
	@Mapping(source = "patient.patientName", target = "patientName")
	@Mapping(source = "patient.activeIssues", target = "activeIssues")
	@Mapping(source = "patient.allergies", target = "allergies")

	public PatientDto convertToDto(Patient patient); // Entity to Dto
	
	

}
