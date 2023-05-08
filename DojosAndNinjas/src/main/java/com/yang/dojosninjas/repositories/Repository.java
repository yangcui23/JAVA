package com.yang.dojosninjas.repositories;




import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yang.dojosninjas.models.Dojo;

public interface Repository extends CrudRepository<Dojo , Long> {
	List<Dojo> findAll();
	

}
