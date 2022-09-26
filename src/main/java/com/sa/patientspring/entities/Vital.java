package com.sa.patientspring.entities;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vitalId;
	private int ECG;
	private float temperature;
	private int diabetes;
	private int respirationRate;
	
//	private long appointmentId;

}
