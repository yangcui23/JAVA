package com.yang.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dojosninjas.models.Ninja;
import com.yang.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
		@Autowired
		private NinjaRepository ninjaRepository;
		
		
		public List<Ninja> allNinjas() {
	        return ninjaRepository.findAll();
	    }
		
		public Ninja createNinja(Ninja y) {
	        return ninjaRepository.save(y);
	    }
		
		public Ninja findNinja(Long id) {
	        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	        if (optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else
	            return null;
	    }
}
