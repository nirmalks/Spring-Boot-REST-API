package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.model.Cricketer;
import com.example.repository.CricketerRepository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class CricketerService{

	@Autowired
	CricketerRepository cricketerRepository;
	public void save(Cricketer cricketer) {
		cricketerRepository.save(cricketer);
	}

	public Cricketer findById(Long id){
		return cricketerRepository.findById(id).orElseThrow(() ->
				new NoSuchElementException("Cricketer does not exist" + id)
		);
	}

	@Cacheable("cricketers")
	public List<Cricketer> getAllPlayers(){
		return cricketerRepository.findAll();
	}


	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();
	}

}
