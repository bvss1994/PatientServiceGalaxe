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
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long feedbackId;
	
	private int ques1;
	private int ques2;
	private int ques3;
	private int ques4;
	private String additionalComment;
	
	private long appointmentId;

}
