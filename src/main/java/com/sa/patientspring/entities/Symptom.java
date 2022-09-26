package com.sa.patientspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor  
@NoArgsConstructor
public class Symptom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long symp_id;
	private String sympName;
	private long sympReadings;
	private long appointmentId;

}
