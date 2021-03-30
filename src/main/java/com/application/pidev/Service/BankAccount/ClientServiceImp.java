package com.application.pidev.Service.BankAccount;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Repository.BankAccount.*;
@Service
@Transactional
public class ClientServiceImp implements IclientService {
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long codeclt) {
		
		clientRepository.deleteById(codeclt);
		
	}

	@Override
	public Client consultClient(Long codeclt) {
		return clientRepository.getOne(codeclt);
	}

	

}
