package com.sa.patientspring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.controller.dto.FeedbackDto;
import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.entities.Feedback;
import com.sa.patientspring.exceptions.AppointmentNotExistException;
import com.sa.patientspring.exceptions.FeedbackAlreadyExistException;
import com.sa.patientspring.exceptions.FeedbackNotFoundException;
import com.sa.patientspring.mapper.FeedbackMapper;
import com.sa.patientspring.repository.FeedbackRepository;
import com.sa.patientspring.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

//	@Override
//	public Feedback addfeedback(Feedback fb, long aid, long pid)
//			throws AppointmentNotExistException, InvalidAnsException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Feedback viewFeedbackByAppointmentId(long id4) throws FeedbackNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

	@Override
	public FeedbackDto viewFeedbackByAppointmentIdDto(long id4) throws FeedbackNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	private FeedbackRepository fbrepo;
	
	

//	@Autowired
//	private AppointmentRepository apRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	String appURL = "http://localhost:8094/appointment";

	public FeedbackServiceImpl(FeedbackRepository feedRepo) {
		// TODO Auto-generated constructor stub
		this.fbrepo = feedRepo;
	}
	
//
//	@Override
//	public FeedbackDto getFeedbackByAppointmentId(long id) throws AppointmentNotFoundException {
//		// TODO Auto-generated method stub
//		if (apRepo.existsById(id)) {
//			 Feedback feedback1 = fbrepo.getFeedackByAppId(id);
//			 FeedbackDto feedbackDto = feedbackMapper.convertToDto(feedback1);
//			 return feedbackDto;
//		} else {
//			throw new AppointmentNotFoundException("Appointment not found");
//		}
//	}
//	
//
	@Override
	public Feedback addfeedback(Feedback feedback, long appointmentId)
			throws AppointmentNotExistException, FeedbackAlreadyExistException {

		boolean flag = false;

		if (fbrepo.getAppointmentFeedback(appointmentId) == null) {

			String URL = appURL + "/ApppointmentService/Appointment/getAllApoointment";

			ResponseEntity<Appointment[]> response = restTemplate.getForEntity(URL, Appointment[].class);
			Appointment[] appointments = response.getBody();

			for (int i = 0; i < appointments.length; i++) {

				if (appointments[i].getAppointmentId() == appointmentId) {

					feedback.setAppointmentId(appointmentId);
					fbrepo.save(feedback);
					flag = true;
				}
			}
			if (flag = false) {
				throw new AppointmentNotExistException("Appointment not Exists !");
			}
			return feedback;
		} else {
			throw new FeedbackAlreadyExistException("Feedback Already Exist");
		}
	}

//
	public Feedback viewFeedbackByAppointmentId(long id4) throws FeedbackNotFoundException {

		Feedback feedbk = null;

		boolean flag = false;

		String URL = appURL + "/ApppointmentService/Appointment/getAllApoointment";

		ResponseEntity<Appointment[]> response = restTemplate.getForEntity(URL, Appointment[].class);
		Appointment[] appointments = response.getBody();

		for (int i = 0; i < appointments.length; i++) {

			if (appointments[i].getAppointmentId() == id4) {

				feedbk = fbrepo.getAppointmentFeedback(id4);
				flag = true;

			}
		}
		if (flag == false) {
			throw new FeedbackNotFoundException("Appointment Not Found !");
		}
		return feedbk;

	}

//	@Override
//	public FeedbackDto viewFeedbackByAppointmentIdDto(long id4) throws FeedbackNotFoundException {
//
//		Feedback feedbk = null;
//
//		FeedbackDto feedbackDto = new FeedbackDto();
//
//		if (!appoRepo.existsById(id4)) {
//			throw new FeedbackNotFoundException("Appointment List is Empty !");
//
//		} else {
//
//			feedbk = feedRepo.getAppointmentFeedback(id4);
//
//			feedbackDto = fMapper.convertToDto(feedbk);
//
//		}
//
//		return feedbackDto;
//
//	}

}
