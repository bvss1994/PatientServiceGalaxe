package com.sa.patientspring;


import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sa.patientspring.entities.Appointment;
import com.sa.patientspring.entities.Feedback;
import com.sa.patientspring.entities.Symptom;
import com.sa.patientspring.repository.FeedbackRepository;
import com.sa.patientspring.repository.SymptomsRepository;
import com.sa.patientspring.service.FeedbackService;
import com.sa.patientspring.service.SymptomService;
import com.sa.patientspring.service.impl.FeedbackServiceImpl;
import com.sa.patientspring.service.impl.SymptomServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SymptomTest {
	//private MockMvc mockMvc;
	
	@Mock 
	private SymptomsRepository symRepo;
	
	
	SymptomService symService;
	
	
	@BeforeEach
    void initUseCase() {
        symService = new SymptomServiceImpl(symRepo);
    }
	
	@Test
	public  void addSymptomTest() throws Exception {
		

		Symptom symptom=new Symptom(2L,"symptom1",1L,3L);
		when(symRepo.save(any(Symptom.class))).thenReturn(symptom);

		
		Symptom savedsym= symRepo.save(symptom);
		
		
		assertThat(savedsym).isNotNull();
	}
//	
	@Test
	public void getAllsymptomsTest() throws Exception {
		
		Symptom symptom1=new Symptom(2L,"symptom1",1L,3L);
		Symptom symptom2=new Symptom(7L,"symptom2",9L,23L);
		List<Symptom> symptoms=new ArrayList<>();
		
		symptoms.add(symptom1);
		symptoms.add(symptom2);
	
		symRepo.saveAll(symptoms);
		
	
		assertThat(symRepo.getAllSymptoms()).isNotNull();
//		symRepo.getAppointmentSymptoms(3L);
		
		
	}
	

}