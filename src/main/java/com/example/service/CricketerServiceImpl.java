package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cricketer;
import com.example.repository.CricketerRepository;

@Service
public class CricketerServiceImpl implements CricketerService{

	@Autowired
	CricketerRepository cricketerRepository;
	
	@Override
	public void save(Cricketer cricketer) {
		cricketerRepository.save(cricketer);
	}

	public Cricketer findById(Long id){
		return cricketerRepository.findOne(id);
	}
		
	public List<Cricketer> getAllPlayers(){
		return cricketerRepository.findAll();
	}
}
