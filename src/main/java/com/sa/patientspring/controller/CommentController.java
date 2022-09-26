package com.sa.patientspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sa.patientspring.entities.Comment;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/CommentController")
public class CommentController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/ViewCommentbyAppId/{aid}")
	@Operation(summary = "To view Comment")
	public ResponseEntity<?> getComment(@RequestParam(value = "aid") long aid) {
		ResponseEntity<?> response = null;
		String url = "http://localhost:8001/ApppointmentService/ViewComment/%7Baid%7D?appointment_id=" + aid;
		response = restTemplate.getForEntity(url, Comment.class);
		return response;
	}
}
