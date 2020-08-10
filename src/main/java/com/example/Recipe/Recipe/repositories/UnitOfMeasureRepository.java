package com.example.Recipe.Recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Recipe.Recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
     Optional<UnitOfMeasure> findByDescription(String descriptionString);

}
