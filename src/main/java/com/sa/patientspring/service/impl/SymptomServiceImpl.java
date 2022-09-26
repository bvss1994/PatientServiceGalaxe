package com.sa.patientspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.controller.dto.SymptomsDto;
import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.entities.Symptom;
import com.sa.patientspring.exceptions.AppointmentNotFoundException;
import com.sa.patientspring.exceptions.SymptomNotFoundException;
import com.sa.patientspring.repository.SymptomsRepository;
import com.sa.patientspring.service.SymptomService;

@Service
public class SymptomServiceImpl implements SymptomService {

	@Autowired
	private SymptomsRepository symRepo;

	@Autowired
	RestTemplate restTemplate;

	String appURL = "http://localhost:8094/appointment";
	
	public SymptomServiceImpl(SymptomsRepository sRepo) {
		// TODO Auto-generated constructor stub
		this.symRepo = sRepo;
	}

	@Override
	public List<Symptom> getAllSymptoms() {
		// TODO Auto-generated method stub
		List<Symptom> symptom = null;
		symptom = symRepo.getAllSymptoms();
		return symptom;
	}

	@Override
	public Symptom addSymptoms(Symptom symptom) throws AppointmentNotFoundException {

		long appId = symptom.getAppointmentId();
		String URL = appURL + "/ApppointmentService/Appointment/getAllApoointment";

		ResponseEntity<Appointment[]> response = restTemplate.getForEntity(URL, Appointment[].class);
		Appointment[] appointments = response.getBody();

		for (int i = 0; i < appointments.length; i++) {
			if (appointments[i].getAppointmentId() == appId) {
				
				symptom.setAppointmentId(appId);
				symRepo.save(symptom);
			} else {
				throw new AppointmentNotFoundException();
			}
		}
		return symptom;
	}

	@Override
	public List<Symptom> viewAllSymptomsByAppointmentId(long id2) throws SymptomNotFoundException {

		List<Symptom> sympt = null;
		if (symRepo.getAppointmentSymptoms(id2) == null) {
			throw new SymptomNotFoundException("Symptoms List is Empty !");

		} else {
			sympt = symRepo.getAppointmentSymptoms(id2);
		}

		return sympt;
	}

	@Override
	public List<SymptomsDto> viewAllSymptomsByAppointmentIdDto(long id2) throws SymptomNotFoundException {
		return null;
//		List<Symptom> sympts = null;
//
//		SymptomsDto symptomDtos = new SymptomsDto();
//
//		List<SymptomsDto> symptsDtos = new ArrayList<SymptomsDto>();
//
//		if (patRepo.existsById(id2)) {
//			throw new SymptomNotFoundException("Symptoms List is Empty !");
//
//		} else {
//
//			sympts = symRepo.getAppointmentSymptoms(id2);
//
//			for (Symptom sympt : sympts) {
//
//				symptomDtos = sMapper.convertToDto(sympt);
//				symptsDtos.add(symptomDtos);
//
//			}
//		}
//
//		return symptsDtos;
	}

	@Override
	public Symptom editSymptom(Symptom symptom) throws SymptomNotFoundException {
		// TODO Auto-generated method stub
		Symptom mob2 = null;
		if (symRepo.existsById(symptom.getSymp_id())) {
			mob2 = symRepo.findById(symptom.getSymp_id()).get();
			mob2.setSympName(symptom.getSympName());
			mob2.setSympReadings(symptom.getSympReadings());
		} else
			throw new SymptomNotFoundException("Symptom Not Found...");
		return symRepo.save(mob2);

	}

	@Override
	public Symptom deleteSymptom(long id) throws SymptomNotFoundException {
		// TODO Auto-generated method stub
		Symptom sym = null;
		if (symRepo.existsById(id)) {

			symRepo.deleteById(id);
		} else
			throw new SymptomNotFoundException("Symptom Not Found for this ID...");
		return sym;
	}
}
