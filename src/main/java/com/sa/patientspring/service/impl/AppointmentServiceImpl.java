package com.sa.patientspring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.controller.dto.AppointmentDto;
import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.exceptions.AppointmentDetailsNotExistException;
import com.sa.patientspring.exceptions.AppointmentNotFoundException;
import com.sa.patientspring.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private RestTemplate restTemplate;
	
	String appURL = "http://localhost:8094/appointment";

	@Override
	public List<Appointment> viewAllAppointmentsByPatientsId(long id1) throws AppointmentNotFoundException {
		String URL1 = appURL+ "/ApppointmentService/Appointment/getAllApoointment";
		ResponseEntity<Appointment[]> response1 = restTemplate.getForEntity(URL1, Appointment[].class);
		Appointment[] appointments = response1.getBody();

		List<Appointment> appointments2 = new ArrayList<Appointment>();

		boolean flag = false;
		for (int i = 0; i < appointments.length; i++) {

			if (appointments[i].getPatientId() == id1) {

				flag = true;

				appointments2.add(appointments[i]);
			}
		}

		if (flag == false) {
			throw new AppointmentNotFoundException("No Appointments For You !");

		}

		return appointments2;
	}

	@Override
	public List<AppointmentDto> viewAllAppointmentsByPatientsIdDto(long id1) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment viewAppointmentDetails(long id) throws AppointmentDetailsNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppointmentDto viewAppointmentDetailsDto(long id) throws AppointmentDetailsNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Appointment> viewAllAppointmentsByPatientsId(long id1) throws AppointmentNotFoundException {
//
//		List<Appointment> appoints = null;
//		if (!patRepo.existsById(id1)) {
//			throw new AppointmentNotFoundException("Appointment List is Empty !");
//
//		} else {
//			appoints = appoRepo.getPatientAppointment(id1);
//
//		}
//
//		return appoints;
//	}
//
//	@Override
//	public List<AppointmentDto> viewAllAppointmentsByPatientsIdDto(long id1) throws AppointmentNotFoundException {
//
//		List<Appointment> appoints = null;
//
//		AppointmentDto appointmentDtos = new AppointmentDto();
//
//		List<AppointmentDto> appointsDtos = new ArrayList<AppointmentDto>();
//
//		if (!patRepo.existsById(id1)) {
//			throw new AppointmentNotFoundException("Appointment List is Empty !");
//
//		} else {
//
//			appoints = appoRepo.getPatientAppointment(id1);
//
//			for (Appointment appoint : appoints) {
//
//				appointmentDtos = aMapper.convertToDto(appoint);
//				appointsDtos.add(appointmentDtos);
//
//			}
//		}
//
//		return appointsDtos;
//
//	}
//
//	@Override
//	public Appointment viewAppointmentDetails(long id) throws AppointmentDetailsNotExistException {
//		// TODO Auto-generated method stub
//		Appointment appoint = null;
//		if (!appoRepo.existsById(id)) {
//			throw new AppointmentDetailsNotExistException("Details Not Exist  !");
//		} else {
////			appoint = appoRepo.save(app);
//		}
//		return appoint;
//	}
//
//	@Override
//	public AppointmentDto viewAppointmentDetailsDto(long id) throws AppointmentDetailsNotExistException {
//
////		Appointment appoint = null;
//		AppointmentDto appointDto = new AppointmentDto();
//
//		if (!appoRepo.existsById(id)) {
//			throw new AppointmentDetailsNotExistException("Details Not Exist  !");
//		} else {
////			appoint = appoRepo.save(app);
//		}
//		return appointDto;
//	}

}
