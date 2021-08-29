package com.rest.assignment.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.assignment.model.Event;
import com.rest.assignment.repository.PersonalCalenderRepository;

@Service
public class PersonalCalenderService {
	
	@Autowired
	PersonalCalenderRepository repo;

	public Event getEvent(Long id) {
		Optional<Event> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	public List<Event> getTodayEvent(String date) {

		Instant dateStart = Instant.from(LocalDate.parse(date).atStartOfDay());
		Instant dateEnd = Instant.from(LocalDate.parse(date).atStartOfDay().plusDays(1));
		return repo.findAllByStartBetween(dateStart,dateEnd);
	}

	public List<Event> getAllEvent() {
		return (List<Event>) repo.findAll();
	}

	public Event saveEvent(Event input) {
		Event save = repo.save(input);
		return save;
	}

	public void deleteEvent(Long id) {
		repo.deleteById(id);
		// TODO Auto-generated method stub
	}

}
