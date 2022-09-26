package com.sa.patientspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sa.patientspring.entities.Symptom;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptom, Long> {

	@Query(value = "select * FROM  symptom s where appointment_id = :id2", nativeQuery = true)
	public List<Symptom> getAppointmentSymptoms(@Param(value = "id2") long id2);

	@Query(value = "select * FROM  symptom", nativeQuery = true )
	public List<Symptom> getAllSymptoms();
	
}

