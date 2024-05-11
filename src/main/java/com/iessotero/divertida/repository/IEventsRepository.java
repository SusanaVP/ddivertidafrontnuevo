package com.iessotero.divertida.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iessotero.divertida.model.Events;

@Repository
public interface IEventsRepository extends JpaRepository<Events, Long> {

	@Query("SELECT e FROM Events e")
	List<Events> findAllEvents();
}