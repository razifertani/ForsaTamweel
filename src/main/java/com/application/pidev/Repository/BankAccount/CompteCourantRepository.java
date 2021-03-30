package com.application.pidev.Repository.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccount.*;

public interface CompteCourantRepository extends JpaRepository<CompteCourant, String> {
	
	

}
