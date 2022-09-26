package com.sa.patientspring.controller.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

	private LocalDateTime appointmentDateTime;
	private String issue;
	private String regularity;
	private String status;

}
