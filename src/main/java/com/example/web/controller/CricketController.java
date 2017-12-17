package com.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cricketer;
import com.example.repository.CricketerRepository;
import com.example.service.CricketerService;

@RestController
public class CricketController {
	@Autowired
	CricketerService cricketerService;
	
	@Autowired
	CricketerRepository cricketerRepository;
	
	@GetMapping("/api/cricketer/{id}")
	public ResponseEntity<Cricketer> getCricketer(@PathVariable("id") Long id) {
		Cricketer cricketer = cricketerService.findById(id);
		return new ResponseEntity<Cricketer>(cricketer, HttpStatus.OK);
	}
	
	@GetMapping("/api/cricketers/")
	public ResponseEntity<List<Cricketer>> getAllCricketers() {
		ArrayList<Cricketer >cricketersList = (ArrayList<Cricketer>) cricketerService.getAllPlayers();
		return new ResponseEntity<List<Cricketer>>(cricketersList, HttpStatus.OK);
	}
	
	@PostMapping("/api/cricketer/")
	public ResponseEntity<Cricketer> addCricketer(@RequestBody Cricketer cricketer) {
		System.out.print(cricketer);
		Cricketer cCricketer = new Cricketer();
		cCricketer.setCountry(cricketer.getCountry());
		cCricketer.setName(cricketer.getName());
		cCricketer.setHighestScore(cricketer.getHighestScore());
		cricketerRepository.save(cCricketer);
		return new ResponseEntity<Cricketer>(cricketer, HttpStatus.OK);
	}
	
	@PutMapping("/api/cricketer/{id}")
	public ResponseEntity<Cricketer> updateCricketer(@PathVariable("id") Long id, @RequestBody Cricketer cricketer) {
		Cricketer cCricketer = cricketerService.findById(id);
		cCricketer.setCountry(cricketer.getCountry());
		cCricketer.setName(cricketer.getName());
		cCricketer.setHighestScore(cricketer.getHighestScore());
		cricketerRepository.save(cCricketer);
		return new ResponseEntity<Cricketer>(cricketer, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/cricketer/{id}")
	public ResponseEntity<String> deleteCricketer(@PathVariable("id") Long id) {
		Cricketer cCricketer = cricketerService.findById(id);
		cricketerRepository.delete(cCricketer);
		return new ResponseEntity<String>("cricketer removed", HttpStatus.OK);
	}
}
