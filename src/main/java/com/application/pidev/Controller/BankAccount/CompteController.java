package com.application.pidev.Controller.BankAccount;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Controller.BankAccount.*;
import com.application.pidev.Repository.BankAccount.*;
import com.application.pidev.Service.BankAccount.*;


@RestController
@RequestMapping(value = "/compte")
public class CompteController implements ICompteService {
	

	@Autowired
	IclientService cs;

	@Autowired
	ICompteService comservice;

	@Autowired
	CompteRepository cr;

	@Override
	@GetMapping(value = "/consulterCompte/{code}")
	public Compte consulterCompte(@PathVariable("code") String codeCpte) {
		return comservice.consulterCompte(codeCpte);
	}

	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retirer(String codeCpte, double montant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		// TODO Auto-generated method stub

	}

	
	/*
	 * @Override
	 * 
	 * @PostMapping("/addCompte/{c}/{code}")
	 * 
	 * @ResponseBody public void affecterCompteAUser(@PathVariable("c") Compte
	 * c, @PathVariable("code") Client code) { comservice.affecterCompteAUser(c,
	 * code);f
	 * 
	 * }
	 */

	@Override
	@PostMapping("/addCompte")
	public Compte addCompte(@RequestBody Compte c) {
		System.out.println(c.getSolde());
		System.out.println(c.getCodeCompte());

		return comservice.addCompte(c);
		
		
	}

	@Override
	@GetMapping(value = "getall/{id}")
    @ResponseBody
	public List<Compte> getAllCompteByCODE_CLI(@PathVariable("id")int CODE_CLI) {
		// TODO Auto-generated method stub
		return comservice.getAllCompteByCODE_CLI(CODE_CLI);
	}

	@Override
	@GetMapping("/allComptes")
	 @ResponseBody
	public List<Compte> retrieveAllComptes() {
	
		

		return comservice.retrieveAllComptes();
	}

	@Override
	public void ajouterEtaffecterClientCompte(Client e, Compte d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@PutMapping(value ="/affecterClientACompte/{codeCompte}/{code}")
	@ResponseBody
	public void affecterClientACompte(@PathVariable("codeCompte")String codeCompte,@PathVariable("code") Long code) {
          comservice.affecterClientACompte(codeCompte, code);	
	}

	@Override
	public List<Operation> listOperation(String codeCpte) {
		// TODO Auto-generated method stub
		return null;
	}
	}

	
	





