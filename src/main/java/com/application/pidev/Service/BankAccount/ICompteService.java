package com.application.pidev.Service.BankAccount;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Repository.BankAccount.*;
import com.application.pidev.Service.BankAccount.*;

public interface ICompteService {

	public Compte consulterCompte(String codeCpte);
    public Compte addCompte(Compte c);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	
	public List<Compte> getAllCompteByCODE_CLI(int CODE_CLI ) ;
	
	public List<Compte> retrieveAllComptes() ;
	
	public void ajouterEtaffecterClientCompte (Client e,  Compte d);

	
	public void affecterClientACompte(String codeCompte , Long code);

	
	public List<Operation> listOperation(String codeCpte);

}
