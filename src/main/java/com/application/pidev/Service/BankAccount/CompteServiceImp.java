package com.application.pidev.Service.BankAccount;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Repository.BankAccount.*;
import com.application.pidev.Service.BankAccount.*;

@Service
public class CompteServiceImp implements ICompteService{
	
	private static final Logger L = LogManager.getLogger(CompteServiceImp.class);

	
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ICompteService cs;
	
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Operation v = new Operation(new Date(), montant,  Type.VERSEMENT ,cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse = 0;
		if(cp instanceof CompteCourant)
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde() + facilitesCaisse < montant)
			throw new RuntimeException("Solde insuffisant");
		Operation r = new Operation(new Date(), montant , Type.RETRAIT, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2)){
			throw new RuntimeException("Impossibile de faire un virement sur le même compte");
		}
		retirer(codeCpte1,montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.getOne(codeCpte);
		if(cp == null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public List<Operation> listOperation(String codeCpte) {
		/*
		 * return operationRepository.listOperation(codeCpte);
		 */
		return null ;}

	@Override
	public Compte addCompte(Compte c) {
		

		return compteRepository.save(c);
	}

	@Override
	public List<Compte> getAllCompteByCODE_CLI(int CODE_CLI) {
		return cs.getAllCompteByCODE_CLI(CODE_CLI);
	}

	@Override
	public List<Compte> retrieveAllComptes() {
		List<Compte> cp = (List<Compte>) compteRepository.findAll();
		for (Compte emp : cp) {
			L.info("comptes +++ :" + emp);
		}

		return retrieveAllComptes();
	}

	@Override
	public void ajouterEtaffecterClientCompte(Client e, Compte d) {
		d.setClient(e);
		compteRepository.save(d);			
	}

	@Override
	public void affecterClientACompte(String codeCompte, Long code) {
     Compte c = compteRepository.findById(codeCompte).orElse(null);
     Client e = clientRepository.findById(code).orElse(null);
     c.setClient(e);
     compteRepository.save(c);
	}

	


	
}





	


