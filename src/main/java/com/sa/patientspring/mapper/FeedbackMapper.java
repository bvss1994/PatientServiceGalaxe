package com.sa.patientspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.patientspring.controller.dto.FeedbackDto;
import com.sa.patientspring.entities.Feedback;

@Mapper
public interface FeedbackMapper {
	
	@Mapping(source = "feedback.ques1", target = "ques1")
	@Mapping(source = "feedback.ques2", target = "ques2")
	@Mapping(source = "feedback.ques3", target = "ques3")
	@Mapping(source = "feedback.ques4", target = "ques4")
	@Mapping(source = "feedback.additionalComment", target = "additionalComment")

	public FeedbackDto convertToDto(Feedback feedback); // Entity to Dto
	

}
