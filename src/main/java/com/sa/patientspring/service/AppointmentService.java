package com.sa.patientspring.service;

import java.util.List;

import com.sa.patientspring.controller.dto.AppointmentDto;
import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.exceptions.AppointmentDetailsNotExistException;
import com.sa.patientspring.exceptions.AppointmentNotFoundException;

public interface AppointmentService {

	public List<Appointment> viewAllAppointmentsByPatientsId(long id1) throws AppointmentNotFoundException;

	public List<AppointmentDto> viewAllAppointmentsByPatientsIdDto(long id1) throws AppointmentNotFoundException;

	public Appointment viewAppointmentDetails(long id) throws AppointmentDetailsNotExistException;

	public AppointmentDto viewAppointmentDetailsDto(long id) throws AppointmentDetailsNotExistException;

}
