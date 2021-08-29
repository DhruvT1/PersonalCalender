package com.rest.assignment.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.assignment.model.Event;

@Repository

public interface PersonalCalenderRepository extends CrudRepository<Event, Long>{

	List<Event> findAllByStartBetween (Instant dateStart, Instant dateEnd);
	
	

}
