package com.iessotero.divertida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iessotero.divertida.model.Events;
import com.iessotero.divertida.services.EventsService;

@RestController
@RequestMapping("/events")
public class EventsController {

	@Autowired
	EventsService eventsService;

	@GetMapping()
	public List<Events> getEvents() {
		return eventsService.getAllEvents();
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/addEvent")
	public ResponseEntity<String> addEvent(@RequestBody Events event) {
		try {
			this.eventsService.addEvent(event);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/deleteEvent/{idEvent}")
	public ResponseEntity<String> deleteEVent(@PathVariable Long idEvent) {
		try {
			this.eventsService.deleteBlog(idEvent);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
