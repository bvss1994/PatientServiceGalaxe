package com.sa.patientspring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.patientspring.entities.Feedback;
import com.sa.patientspring.exceptions.AppointmentNotExistException;
import com.sa.patientspring.exceptions.FeedbackAlreadyExistException;
import com.sa.patientspring.exceptions.FeedbackNotFoundException;
import com.sa.patientspring.exceptions.InvalidAnsException;
import com.sa.patientspring.service.FeedbackService;

//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

@RestController
@RequestMapping("/FeedbackProfiles")
public class FeedbackController {

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("spring-swagger").description("Swagger setup in spring").license("Apache 2.0")
//				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
//				.termsOfServiceUrl("https://ankitech/tems").version("1.0.0").build();
//	}

	@Autowired
	private FeedbackService feedService;

	@PostMapping("/newfeedback/{appointmentId}")
	public ResponseEntity<?> addfeedback(@RequestBody Feedback feedback, @PathVariable(value = "appointmentId") long appointmentId) throws InvalidAnsException, FeedbackAlreadyExistException {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(feedService.addfeedback(feedback, appointmentId), HttpStatus.OK);
		} catch (AppointmentNotExistException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		} 
		return response;
	}
	
	@GetMapping("/viewAppointmentFeedback/{appId}")
	public ResponseEntity<?> getFeedbackById(@PathVariable(value = "appId") int appId) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(feedService.viewFeedbackByAppointmentId(appId), HttpStatus.OK);

		} catch (FeedbackNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}

		return response;
	}
	
//	@GetMapping("/viewAppointmentFeedbackDto/{id4}")
//	public ResponseEntity<?> getFeedbackByIdDto(@PathVariable(value = "id4") int id4) {
//		ResponseEntity<?> response = null;
//		try {
//			response = new ResponseEntity<>(feedService.viewFeedbackByAppointmentIdDto(id4), HttpStatus.OK);
//
//		} catch (FeedbackNotFoundException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//
//		}
//
//		return response;
//	}

}
