package com.yang.savetravel.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yang.savetravel.models.TravelModel;
import com.yang.savetravel.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    
    public List<TravelModel> allExpenses() {
        return travelRepository.findAll();
    }
    
    public TravelModel createTravel(TravelModel b) {
        return travelRepository.save(b);
    }
    
    public TravelModel findTravel(Long id) {
        Optional<TravelModel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    
    public TravelModel updateTravel(TravelModel expense) {
        Optional<TravelModel> optionalTravel = travelRepository.findById(expense.getId());
        if (optionalTravel.isPresent()) {
            return travelRepository.save(expense);
        } else {
            return null;
        }
    }
    
    public String delete(Long id) {
        Optional<TravelModel> optionalTravel = travelRepository.findById(id);
        if (optionalTravel.isPresent()) {
            travelRepository.deleteById(id);
            return "Deleted";
        } else {
            return "No expense to delete";
        }
    }
}
