package com.example.service;

import java.util.List;

import com.example.model.Cricketer;

public interface CricketerService {
	void save(Cricketer cricketer);
	Cricketer findById(Long id);
	List<Cricketer> getAllPlayers();	
}
