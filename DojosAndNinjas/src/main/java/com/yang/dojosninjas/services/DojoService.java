package com.yang.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yang.dojosninjas.models.Dojo;
import com.yang.dojosninjas.repositories.Repository;

@Service
public class DojoService {

	
private final Repository repository;
	    
	    public DojoService(Repository repository) {
	        this.repository = repository;
	    }
	    
	    public List<Dojo> allDojos() {
	        return repository.findAll();
	    }
	    
	    public Dojo createDojo(Dojo b) {
	        return repository.save(b);
	    }
	    
	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = repository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public  Dojo updateDojo(Dojo dojo) {
	        Optional<Dojo> optionalDojo = repository.findById(dojo.getId());
	        if (optionalDojo.isPresent()) {
	            return repository.save(dojo);
	        } else {
	            return null;
	        }
	    }
	    
	    public String delete(Long id) {
	        Optional<Dojo> optionalDojo = repository.findById(id);
	        if (optionalDojo.isPresent()) {
	            repository.deleteById(id);
	            return "Deleted";
	        } else {
	            return "No dojo to delete";
	        }
	    }
	}


