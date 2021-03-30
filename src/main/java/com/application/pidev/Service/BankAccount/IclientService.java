package com.application.pidev.Service.BankAccount;

import java.util.List;

import org.springframework.stereotype.Service;
import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Controller.BankAccount.*;

public interface IclientService {
	
	public Client addClient(Client c);
	public void deleteClient(Long codeclt);
	public Client consultClient (Long codeclt);
	//List<Compte> listCompte();

}
