package com.elena.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elena.project.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
	List<Client> findByLastName(String lastName);

}
