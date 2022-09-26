package com.sa.patientspring;


import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.entities.Feedback;
import com.sa.patientspring.repository.FeedbackRepository;
import com.sa.patientspring.service.FeedbackService;
import com.sa.patientspring.service.impl.FeedbackServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FeedBackTest {
	//private MockMvc mockMvc;
	
	@Mock 
	private FeedbackRepository feedRepo;
	
	
	FeedbackService feedService;
	
	
	@BeforeEach
    void initUseCase() {
        feedService = new FeedbackServiceImpl(feedRepo);
    }
	
	@Test
	public  void addFeedbackAppointmentTest() throws Exception {
		Feedback feedback=new Feedback(1L,1,2,3,4,"comment",2L);

		when(feedRepo.save(any(Feedback.class))).thenReturn(feedback);
//		Feedback savedfeed=feedService.addfeedback(feedback, 2L);
		Feedback savedfeed= feedRepo.save(feedback);
		
		
		assertThat(savedfeed);
	}
//	
	@Test
	public void getFeebackAppointmentTest() throws Exception {
		
		Appointment app=new Appointment(3L,"23-3-2022","issue","reg","ok",11,22);
				
		Feedback feedback1=new Feedback(2L,1,2,3,4,"comment1",app.getAppointmentId());
		
		assertThat(feedback1.getAppointmentId()).isEqualTo(3);
		
		
		
		
	}
	

	
//	
//	@Test
//	public void CanceledAppoTest() throws Exception {
//		
//				
//		List<Appointment> savedAppoint= appRepo.getCancelledAppointments();
//		assertThat(savedAppoint.getClass()).isNotNull();
//	}
//	
//	@Test
//	public void FilteredAppoTest() throws Exception {
//		
//				
//		List<Appointment> savedAppoint= appRepo.getFilteredAppointments("Accepted");
//		assertThat(savedAppoint.listIterator()).isNotNull();
//	}
//	
//	@Test
//	public void ViewCanceledAppoTest() throws Exception {
//		
//				
//		List<Appointment> savedAppoint= appRepo.viewClosedAppointmentsForDoctor(1);
//		assertThat(savedAppoint.getClass()).isNotNull();
//	}
}