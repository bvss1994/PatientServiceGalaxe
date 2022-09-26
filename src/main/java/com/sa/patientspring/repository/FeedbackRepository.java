package com.sa.patientspring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa.patientspring.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	
	@Query(value = "select * from feedback f where f.appointment_id = :id4", nativeQuery = true )
	public Feedback getAppointmentFeedback(@Param (value = "id4") long id4);
	

	
	

}
