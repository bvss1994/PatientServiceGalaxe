package com.sa.patientspring.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.exceptions.AppointmentNotFoundException;
import com.sa.patientspring.service.AppointmentService;


@RestController
@RequestMapping("/AppointmentProfiles")
public class AppointmentController {

	@Autowired
	private AppointmentService appService;

	@Autowired
	private RestTemplate restTemplate;

//	@Value(value = "${rest.appointmentURL}")
//	String appointmentBaseUrl;
//
//	@PostMapping(value = "/appointment/patient")
//	@Operation(summary = "Rest Template save appointment")
//	public String addAppointment(@RequestBody Appointment app) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Appointment> entity = new HttpEntity<Appointment>(app, headers);
//		String URL = appointmentBaseUrl + "/ApppointmentService/Appointment";
//		return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
//	}

//	@GetMapping("/getAppointmentsByPatientId/{id1}")
//	public ResponseEntity<?> getAllAppointmentsByPatientsId(@PathVariable(value = "id1") int id1) {
//		ResponseEntity<?> response = null;
//		try {
//			response = new ResponseEntity<>(appService.viewAllAppointmentsByPatientsId(id1), HttpStatus.OK);
//
//		} catch (AppointmentNotFoundException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//
//		}
//
//		return response;
//	}

	@PostMapping(value = "/SaveAppointment")
	   public String saveAppointment(@RequestBody Appointment appointment) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Appointment> entity = new HttpEntity<Appointment>(appointment,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8001/ApppointmentService/SaveAppointment", HttpMethod.POST, entity, String.class).getBody();
	   }
	
	@GetMapping("/getAppointmentsByPatientIdDto/{id1}")
	public ResponseEntity<?> getAllAppointmentsByPatientsIdDto(@PathVariable(value = "id1") int id1) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAllAppointmentsByPatientsIdDto(id1), HttpStatus.OK);

		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}

		return response;
	}
	
	@GetMapping("/getAppointmentsByPatientId/{patId}")
	public ResponseEntity<?> getAllAppointmentsByPatientsId(@PathVariable(value = "patId") int patId) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAllAppointmentsByPatientsId(patId), HttpStatus.OK);

		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}

		return response;
	}

}
