package com.sa.patientspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long commentId;
	private String commentDesc;
	
//	private long appointmentId;
}
