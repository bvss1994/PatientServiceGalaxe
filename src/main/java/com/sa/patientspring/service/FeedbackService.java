package com.sa.patientspring.service;

import com.sa.patientspring.controller.dto.FeedbackDto;
import com.sa.patientspring.entities.Feedback;
import com.sa.patientspring.exceptions.AppointmentNotExistException;
import com.sa.patientspring.exceptions.FeedbackAlreadyExistException;
import com.sa.patientspring.exceptions.FeedbackNotFoundException;
import com.sa.patientspring.exceptions.InvalidAnsException;

public interface FeedbackService {

//	public Feedback addfeedback(Feedback fb,long aid,long pid) throws AppointmentNotExistException, InvalidAnsException;

	public Feedback viewFeedbackByAppointmentId(long id4) throws FeedbackNotFoundException;
	
	public FeedbackDto viewFeedbackByAppointmentIdDto(long id4) throws FeedbackNotFoundException;

	Feedback addfeedback(Feedback feedback, long appointmentId)
			throws AppointmentNotExistException, InvalidAnsException, FeedbackAlreadyExistException;
}
