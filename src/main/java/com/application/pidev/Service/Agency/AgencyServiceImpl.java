package com.application.pidev.Service.Agency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.pidev.Entity.Agency.*;
import com.application.pidev.Repository.Agency.*;

@Service
public class AgencyServiceImpl implements AgencyService{
	
	@Autowired
	AgencyRepository repository;

	@Override
	public List<Agency> getAllAgency() {
		return (List<Agency>)repository.findAll();
	}

	@Override
	public Agency getById(long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public Agency addAgency(Agency agency) {
		return repository.save(agency);
		
	}

	@Override
	public void deleteAgency(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Agency updateAgency (Agency agency) {
		return repository.save(agency);
	}

}
