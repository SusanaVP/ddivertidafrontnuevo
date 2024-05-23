package com.iessotero.divertida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iessotero.divertida.model.CategoriesRiddles;
import com.iessotero.divertida.model.Riddles;
import com.iessotero.divertida.repository.IRiddlesRepository;

@Service
public class RiddlesService {

	@Autowired
	private IRiddlesRepository riddlesRepository;

	public List<Riddles> getAllRiddles() {
		return riddlesRepository.findAll();
	}

	public List<Riddles> getRiddlesById(Long categoryId) {
		return riddlesRepository.findByCategoriesRiddleId(categoryId);
	}

	public void deleteRiddle(Long idRiddle) {
		riddlesRepository.deleteById(idRiddle);
	}

	public void addRiddle(Riddles riddle) {
		riddlesRepository.save(riddle);
	}

	public List<CategoriesRiddles> getRiddleCategories() {
		return riddlesRepository.findAllCategoriesRiddles();
	}

}
