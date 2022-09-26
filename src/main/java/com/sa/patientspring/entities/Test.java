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
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long testId;
	private String testName;
	private long appointmentId;
}
