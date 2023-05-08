package com.yang.savetravel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yang.savetravel.models.TravelModel;

public interface TravelRepository extends CrudRepository<TravelModel,Long>{
	List<TravelModel> findAll();
	
	List<TravelModel> findByDescriptionContaining(String name);
	
	Long countByNameContaining(String name);
	
	Long deleteByNameStartingWith(String name);
}
