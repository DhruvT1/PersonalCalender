package com.rest.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rest.assignment.model.Event;
import com.rest.assignment.service.PersonalCalenderService;

@Controller
public class PersonalCalenderController {
	
	@Autowired
	PersonalCalenderService service;
	
	@GetMapping("/getEvent/{id}")
	public Event getEvent(@PathVariable("id") Long id){
		Event event = service.getEvent(id);
		
		return  event;
		
	}
	
	@GetMapping("/getTodayEven/{date}")
	public List<Event> getTodayEvent(@PathVariable("date") String date){
		List<Event> event = service.getTodayEvent(date);
		return event;
		
	}
	
	@GetMapping("/getAllEvent")
	public List<Event> getAllEvent(){
		List<Event> eventList = service.getAllEvent();
		return eventList;
		
	}
	
	
	@PostMapping("/saveEvent")
	public Event saveEvent(@RequestBody Event inputEvent){
		return service.saveEvent(inputEvent);
		
		
	}
	
	@DeleteMapping("/deleteEvent/{id}")
	public void deleteEvent(Long id){
		service.deleteEvent(id);
		
		
	}
	

}
