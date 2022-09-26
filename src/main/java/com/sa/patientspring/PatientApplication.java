package com.sa.patientspring;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.mapper.AppointmentMapper;
import com.sa.patientspring.mapper.AppointmentMapperImpl;
import com.sa.patientspring.mapper.FeedbackMapper;
import com.sa.patientspring.mapper.FeedbackMapperImpl;
import com.sa.patientspring.mapper.PatientMapper;
import com.sa.patientspring.mapper.PatientMapperImpl;
import com.sa.patientspring.mapper.SymptomsMapper;
import com.sa.patientspring.mapper.SymptomsMapperImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Patient Service", version = "1.0", description = "API for Patient Service"))
//@EnableEurekaClient
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PatientMapper getpMapper() {
		return new PatientMapperImpl();
	}

	@Bean
	public AppointmentMapper getaMapper() {
		return new AppointmentMapperImpl();
	}

	@Bean
	public SymptomsMapper getsMapper() {
		return new SymptomsMapperImpl();
	}

	@Bean
	public FeedbackMapper getfMapper() {
		return new FeedbackMapperImpl();
	}

}
