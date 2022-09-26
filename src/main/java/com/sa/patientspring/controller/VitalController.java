package com.sa.patientspring.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.entities.Vital;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/VitalService")
public class VitalController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value ="/ViewVital/{appId}")
	@Operation(summary = "To view Vital")
	public ResponseEntity<Vital> viewVital(@PathVariable("appId") long appId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String url="http://localhost:8001/VitalService/ViewVitals/v/%7Baid%7D?aid="+appId;
		return restTemplate.getForEntity(url,Vital.class);
//		 restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}
}
