package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Cricketer;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer,Long>{

}
