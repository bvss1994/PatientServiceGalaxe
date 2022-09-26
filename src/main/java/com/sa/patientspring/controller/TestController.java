package com.sa.patientspring.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.entities.Test;

@RestController
@RequestMapping("/TestProfiles")
public class TestController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/getTest/{aid}")
	public String getTest(@PathVariable long aid) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Test> entity = new HttpEntity<Test>(headers);

		return restTemplate.exchange("http://localhost:8001/TestService/ViewTests/%7Baid%7D?appointment_id=" + aid,
				HttpMethod.GET, entity, String.class).getBody();
	}
}
