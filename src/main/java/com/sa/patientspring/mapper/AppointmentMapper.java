package com.sa.patientspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.patientspring.controller.dto.AppointmentDto;
import com.sa.patientspring.entities.Appointment;

@Mapper
public interface AppointmentMapper {
	
	@Mapping(source = "appointment.appointmentDateTime", target = "appointmentDateTime")
	@Mapping(source = "appointment.issue", target = "issue")
	@Mapping(source = "appointment.regularity", target = "regularity")
	@Mapping(source = "appointment.status", target = "status")


	public AppointmentDto convertToDto(Appointment appointment); // Entity to Dto
	

}
