package com.sa.patientspring.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long recommendationId;
	
//	@OneToOne
//	@JoinColumn(name = "doctorId")
//	private Doctor doctor;
	
	@OneToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}
