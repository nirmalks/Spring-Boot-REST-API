package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.model.Cricketer;

import java.util.Optional;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer,Long>{
    @Override
    Optional<Cricketer> findById(@Param("id")Long aLong);

    @RestResource(path="searchByName", rel="searchByName")
    Optional<Cricketer> findByName(@Param("name")String name);

    Page<Cricketer> findById(@Param("id")Long aLong, Pageable pageable);
}
