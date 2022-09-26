package com.sa.patientspring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.patientspring.entities.Symptom;
import com.sa.patientspring.exceptions.AppointmentNotFoundException;
import com.sa.patientspring.exceptions.IdNotExistException;
import com.sa.patientspring.exceptions.SymptomNotFoundException;
import com.sa.patientspring.service.SymptomService;

//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

@RestController
@RequestMapping("/SymptomsProfiles")
public class SymptomsController {

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
	private SymptomService symService;

	@PostMapping("/addSymptom/{appId}")
	public ResponseEntity<?> addSymptoms(@RequestBody Symptom symp) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(symService.addSymptoms(symp), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/getSymptomsByAppointmentId/{id2}")
	public ResponseEntity<?> getAllSymptomsByAppointmentsId(@PathVariable(value = "id2") long id2)
			throws IdNotExistException {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(symService.viewAllSymptomsByAppointmentId(id2), HttpStatus.OK);

		} catch (SymptomNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}

		return response;
	}

	@GetMapping("/getAllSymptoms")
	public ResponseEntity<?> getAllSymptoms() {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(symService.getAllSymptoms(), HttpStatus.OK);
		return response;
	}

//	@GetMapping("/getSymptomsByAppointmentIdDto/{id2}")
//	public ResponseEntity<?> getAllSymptomsByAppointmentsIdDto(@PathVariable(value = "id2") int id2) {
//		ResponseEntity<?> response = null;
//		try {
//			response = new ResponseEntity<>(service.viewAllSymptomsByAppointmentIdDto(id2), HttpStatus.OK);
//
//		} catch (SymptomNotFoundException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//
//		}
//
//		return response;
//	}

	@PutMapping("/editsymptom")
	public ResponseEntity<?> put(@RequestBody Symptom mobs) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(symService.editSymptom(mobs), HttpStatus.OK);
		} catch (SymptomNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@DeleteMapping("/delete/{symptomid}")
	public ResponseEntity<?> delete(@PathVariable(value = "symptomid") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(symService.deleteSymptom(id), HttpStatus.OK);
		} catch (SymptomNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

}
