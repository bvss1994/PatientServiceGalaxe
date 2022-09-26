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
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long appointmentId;
	private String appointmentDateTime;
	private String issue;
	private String regularity;
	private String status;
	
	private long patientId;
	private long doctorId;
	
//	@OneToOne (cascade = CascadeType.ALL)
//	@JoinColumn(name = "symp_id")
//	private Symptoms symp;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "Appo_Symp", joinColumns = @JoinColumn(name = "appointmentId"), inverseJoinColumns = @JoinColumn(name = "symp_id"))
//	private List<Symptoms> sympappo = new ArrayList<Symptoms>();
	
	
	
//	@OneToOne
//	@JoinColumn(name = "commentId")
//	private Comment comment;
//
//	@OneToOne
//	@JoinColumn(name = "recommendationId")
//	private Recommendation reccomendation;
//
//	@OneToOne
//	@JoinColumn(name = "vitalId")
//	private Vital vital;
//
//	@OneToMany
//	@JoinColumn(name = "appointmentId")
//	private List<Prescription> prescriptions = new ArrayList<Prescription>();
//
//	@OneToMany
//	@JoinColumn(name = "appointmentId")
//	private List<Test> tests = new ArrayList<Test>();
//
//	@OneToOne
//	@JoinColumn(name = "feedbackId")
//	private Feedback feedback;
	
	

}
