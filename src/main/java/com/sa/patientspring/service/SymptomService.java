package com.sa.patientspring.service;

import java.util.List;

import com.sa.patientspring.controller.dto.SymptomsDto;
import com.sa.patientspring.entities.Symptom;
import com.sa.patientspring.exceptions.AppointmentNotFoundException;
import com.sa.patientspring.exceptions.IdNotExistException;
import com.sa.patientspring.exceptions.SymptomNotFoundException;

public interface SymptomService {

	public Symptom addSymptoms(Symptom symptom) throws AppointmentNotFoundException;

	public List<Symptom> viewAllSymptomsByAppointmentId(long id2) throws SymptomNotFoundException, IdNotExistException;

	public List<SymptomsDto> viewAllSymptomsByAppointmentIdDto(long id2) throws SymptomNotFoundException;

	public List<Symptom> getAllSymptoms();

	Symptom editSymptom(Symptom symptom) throws SymptomNotFoundException;

	Symptom deleteSymptom(long id) throws SymptomNotFoundException;
}
